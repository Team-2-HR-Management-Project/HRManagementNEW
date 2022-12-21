package com.team2.service;

import com.team2.dto.request.ActivateUserRequestDto;
import com.team2.dto.request.CreateRequestDto;
import com.team2.dto.request.UpdateRequestDto;
import com.team2.dto.response.DetailResponseDto;
import com.team2.dto.response.SummaryResponseDto;
import com.team2.exception.ErrorType;
import com.team2.exception.UserManagerException;
import com.team2.manager.IAuthManager;
import com.team2.mapper.IUserMapper;
import com.team2.repository.IUserRepository;
import com.team2.repository.entity.User;
import com.team2.repository.enums.ERole;
import com.team2.repository.enums.EStatus;
import com.team2.utility.JwtTokenManager;
import com.team2.utility.ServiceManager;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends ServiceManager<User, Long> {

    private final IUserRepository userRepository;
    private final IAuthManager authManager;
    private final JwtTokenManager jwtTokenManager;
    public UserService(IUserRepository userRepository,IAuthManager authManager,JwtTokenManager jwtTokenManager) {
        super(userRepository);
        this.userRepository = userRepository;
        this.authManager=authManager;
        this.jwtTokenManager=jwtTokenManager;
    }
    public Boolean createUser(CreateRequestDto dto){
        try{
            User user = userRepository.save(IUserMapper.INSTANCE.toUser(dto));
            return true;
        }catch (Exception e){
            throw new UserManagerException(ErrorType.USER_NOT_CREATED);
        }
    }
    public DetailResponseDto updateUser(UpdateRequestDto dto){
        Optional<User> user=userRepository.findOptionalByAuthid(dto.getAuthid());
        if(user.isPresent()){
            try{
                user.get().setPhone(dto.getPhone());
                user.get().setAddress(dto.getAddress());
                user.get().setPhoto(dto.getPhoto());
                save(user.get());
                return IUserMapper.INSTANCE.toDetailResponseDto(user.get());
            }catch (Exception e){
                throw new UserManagerException(ErrorType.USER_NOT_UPDATED);
            }
        }else{
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }


    }
    public List<SummaryResponseDto> findAllSummary(){

        List<User> users = userRepository.findAll();
        return users.stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }

    public List<SummaryResponseDto> findAllManager(){

        Optional<List<User>> users = userRepository.findAllOptionalByRole(ERole.MANAGER);
        return users.get().stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }
    public List<SummaryResponseDto> findAllEmployee(){

        Optional<List<User>> users = userRepository.findAllOptionalByRole(ERole.EMPLOYEE);
        return users.get().stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }
    public DetailResponseDto seeDetail(Long authid){

        Optional<User> user=userRepository.findOptionalByAuthid(authid);
        if (user.isPresent()){
            return IUserMapper.INSTANCE.toDetailResponseDto(user.get());
        }else {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }

    }

    public boolean deleteUser(Long authid) {
        Optional<User> user=userRepository.findOptionalByAuthid(authid);
        if(user.isPresent()){
            user.get().setStatus(EStatus.INACTIVE);
            save(user.get());
            return true;
        }else{
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
    }

    public boolean activateUser(ActivateUserRequestDto dto) {
        Optional<User> user=userRepository.findOptionalByAuthid(dto.getAuthid());
        if(user.isPresent()){

            user.get().setPhone(dto.getPhone());
            user.get().setAddress(dto.getAddress());
            user.get().setDepartment(dto.getDepartment());
            user.get().setProfession(dto.getProfession());
            user.get().setPhoto(dto.getPhoto());
            user.get().setMiddleName(dto.getMiddleName());
            user.get().setSecondSurname(dto.getSecondSurname());
            user.get().setDob(dto.getDob());
            user.get().setPlaceOfBirth(dto.getPlaceOfBirth());
            user.get().setJoinDate(dto.getJoinDate());


            save(user.get());

            return true;
        }else{
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
    }


    public User getById(Long id) {
        Optional<User> user = userRepository.findOptionalByAuthid(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
    }

    public DetailResponseDto findByToken(String token) {
        Optional<Long> authid = jwtTokenManager.getUserId(token);
        if (authid.isPresent()) {
            Optional<User> user = userRepository.findOptionalByAuthid(authid.get());
            if (user.isPresent()) {
                return IUserMapper.INSTANCE.toDetailResponseDto(user.get());
            } else {
                throw new UserManagerException(ErrorType.USER_NOT_FOUND);
            }

        } else {
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }



    }
}
