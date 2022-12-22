package com.team2.service;

import com.team2.dto.request.*;
import com.team2.dto.response.CreatePasswordResponseDto;
import com.team2.dto.response.LoginResponseDto;
import com.team2.dto.response.RegisterByMailResponseDto;
import com.team2.dto.response.RegisterResponseDto;
import com.team2.exception.AuthManagerException;
import com.team2.exception.ErrorType;
import com.team2.manager.IEmailManager;
import com.team2.manager.IUserManager;
import com.team2.mapper.IAuthMapper;
import com.team2.repository.IAuthRepository;
import com.team2.repository.entity.Auth;
import com.team2.repository.enums.ERole;
import com.team2.repository.enums.EStatus;
import com.team2.utility.JwtTokenManager;
import com.team2.utility.PasswordGenerator;
import com.team2.utility.ServiceManager;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final JwtTokenManager jwtTokenManager;
    private final IUserManager userManager;
    private final IEmailManager emailManager;


    public AuthService(IAuthRepository authRepository,JwtTokenManager jwtTokenManager,IUserManager userManager,IEmailManager emailManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.jwtTokenManager=jwtTokenManager;
        this.userManager=userManager;
        this.emailManager=emailManager;
    }
    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

        if (dto.getAdminCode() != null && dto.getAdminCode().equals("admin")) {
            auth.setRole(ERole.ADMIN);
            auth.setStatus(EStatus.ACTIVE);
        }else if(dto.getAdminCode() != null && dto.getAdminCode().equals("manager")){
            auth.setRole(ERole.MANAGER);
        }
        try {
            save(auth);

            userManager.createUser(CreateRequestDto.builder()
                    .authid(auth.getId())
                    .email(auth.getEmail())
                    .name(dto.getName())
                    .surname(dto.getSurname())
                    .identityNumber(dto.getIdentityNumber())
                    .build());

            return IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthManagerException(ErrorType.AUTH_NOT_CREATED);

        }
    }

    public Optional<LoginResponseDto> login(LoginRequestDto dto) {
        Optional<Auth> auth = authRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (auth.isPresent()) {
            LoginResponseDto loginResponseDto = IAuthMapper.INSTANCE.toLoginResponseDto(auth.get());
            String token = jwtTokenManager.createToken(loginResponseDto.getId());
            loginResponseDto.setToken(token);
            return Optional.of(loginResponseDto);
        } else {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR_WRONG);
        }
    }


    @Transactional
    public boolean deleteAuth(String token) {
        Optional<Long> authId = jwtTokenManager.getUserId(token);
        if (authId.isEmpty()) throw new AuthManagerException(ErrorType.INVALID_TOKEN);
        Optional<Auth> auth = authRepository.findById(authId.get());
        if (auth.isEmpty()) throw new AuthManagerException(ErrorType.AUTH_NOT_FOUND);
        try {
            auth.get().setStatus(EStatus.INACTIVE);
            save(auth.get());
            userManager.deleteUser(auth.get().getId());

            return true;
        } catch (Exception e) {
            throw new AuthManagerException(ErrorType.AUTH_NOT_DELETED);
        }
    }

    @Transactional
    public RegisterByMailResponseDto registerByMail(RegisterByMailRequestDto dto) {
        Auth auth =Auth.builder().email(dto.getEmail()).build();
        if (dto.getRole() != null && dto.getRole().equals(ERole.ADMIN)) {
            auth.setRole(ERole.ADMIN);
            auth.setStatus(EStatus.ACTIVE);
            auth.setPassword("Admin1234!");
        }else if(dto.getRole() != null && dto.getRole().equals(ERole.MANAGER)){
            auth.setRole(ERole.MANAGER);
            auth.setTemppassword(PasswordGenerator.generateCode(UUID.randomUUID().toString()));

        }else{
            auth.setTemppassword(PasswordGenerator.generateCode(UUID.randomUUID().toString()));
        }
        try {

            save(auth);
            userManager.createUser(CreateRequestDto.builder()
                    .authid(auth.getId())
                    .email(auth.getEmail())
                    .name(dto.getName())
                    .surname(dto.getSurname())
                    .role(dto.getRole())
                    .companyid(dto.getCompanyid())
                    .build());

            RegisterByMailResponseDto registerByMailResponseDto=RegisterByMailResponseDto.builder()
                    .email(auth.getEmail())
                    .id(auth.getId())
                    .temppassword(auth.getTemppassword())
                    .build();


                emailManager.sendMail(registerByMailResponseDto);



            return registerByMailResponseDto;

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthManagerException(ErrorType.AUTH_NOT_CREATED);
        }
    }

    public CreatePasswordResponseDto createPassword(CreatePasswordRequestDto dto){
        Optional<Auth> auth= authRepository.findOptionalByEmailAndTemppassword(dto.getEmail(),dto.getTemppassword());
        if(auth.isPresent()){

            auth.get().setStatus(EStatus.ACTIVE);
            auth.get().setPassword(dto.getPassword());
            auth.get().setTemppassword("consumed");
            save(auth.get());

            return CreatePasswordResponseDto.builder()
                    .email(auth.get().getEmail())
                    .id(auth.get().getId())
                    .build();

        }else{
            throw new AuthManagerException(ErrorType.AUTH_NOT_FOUND);
        }

    }


}
