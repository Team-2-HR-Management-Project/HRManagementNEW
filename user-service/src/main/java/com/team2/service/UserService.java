package com.team2.service;

import com.team2.dto.request.ActivateUserRequestDto;
import com.team2.dto.request.CreateRequestDto;
import com.team2.dto.request.UpdateAllRequestDto;
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
    public List<SummaryResponseDto> findAllEmployee(Long companyid){

        Optional<List<User>> users = userRepository.findAllOptionalByRoleAndCompanyid(ERole.EMPLOYEE,companyid);
        return users.get().stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }
//    public List<SummaryResponseDto> findAllMyEmployee(Long companyid){
//
//        Optional<List<User>> users = userRepository.findAllOptionalByCompanyid(companyid);
//        return users.get().stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
//    }
    public DetailResponseDto seeDetail(Long authid){

        Optional<User> user=userRepository.findOptionalByAuthid(authid);
        if (user.isPresent()){
            return DetailResponseDto.builder()
                    .id(user.get().getId())
                    .authid(user.get().getAuthid())
                    .name(user.get().getName())
                    .middleName(user.get().getMiddleName())
                    .surname(user.get().getSurname())
                    .secondSurname(user.get().getSecondSurname())
                    .email(user.get().getEmail())
                    .phone(user.get().getPhone())
                    .address(user.get().getAddress())
                    .photo(user.get().getPhoto())
                    .dob(user.get().getDob())
                    .placeOfBirth(user.get().getPlaceOfBirth())
                    .joinDate(user.get().getJoinDate())
                    .department(user.get().getDepartment())
                    .profession(user.get().getProfession())
                    .role(user.get().getRole().toString())
                    .identityNumber(user.get().getIdentityNumber())
                    .build();
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
                return DetailResponseDto.builder()
                        .id(user.get().getId())
                        .authid(user.get().getAuthid())
                        .companyid(user.get().getCompanyid())
                        .name(user.get().getName())
                        .middleName(user.get().getMiddleName())
                        .surname(user.get().getSurname())
                        .secondSurname(user.get().getSecondSurname())
                        .email(user.get().getEmail())
                        .phone(user.get().getPhone())
                        .address(user.get().getAddress())
                        .photo(user.get().getPhoto())
                        .dob(user.get().getDob())
                        .placeOfBirth(user.get().getPlaceOfBirth())
                        .joinDate(user.get().getJoinDate())
                        .department(user.get().getDepartment())
                        .profession(user.get().getProfession())
                        .role(user.get().getRole().toString())
                        .identityNumber(user.get().getIdentityNumber())
                        .build();
            } else {
                throw new UserManagerException(ErrorType.USER_NOT_FOUND);
            }

        } else {
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }



    }

    public DetailResponseDto updateAllUser(UpdateAllRequestDto dto) {
        Optional<User> user=userRepository.findOptionalByAuthid(dto.getAuthid());
        if(user.isPresent()){
            try{
                user.get().setPhone(dto.getPhone());
                user.get().setAddress(dto.getAddress());
                user.get().setName(dto.getName());
                user.get().setSurname(dto.getSurname());
                user.get().setPhoto(dto.getPhoto());
                user.get().setMiddleName(dto.getMiddleName());
                user.get().setSecondSurname(dto.getSecondSurname());
                user.get().setDob(dto.getDob());
                user.get().setPlaceOfBirth(dto.getPlaceOfBirth());
                user.get().setJoinDate(dto.getJoinDate());
                user.get().setProfession(dto.getProfession());
                user.get().setIdentityNumber(dto.getIdentityNumber());
                save(user.get());
                 return DetailResponseDto.builder()
                        .id(user.get().getId())
                        .authid(user.get().getAuthid())
                        .name(user.get().getName())
                        .middleName(user.get().getMiddleName())
                        .surname(user.get().getSurname())
                        .secondSurname(user.get().getSecondSurname())
                        .email(user.get().getEmail())
                        .phone(user.get().getPhone())
                        .address(user.get().getAddress())
                        .photo(user.get().getPhoto())
                        .dob(user.get().getDob())
                         .companyid(user.get().getCompanyid())
                         .placeOfBirth(user.get().getPlaceOfBirth())
                        .joinDate(user.get().getJoinDate())
                        .department(user.get().getDepartment())
                        .profession(user.get().getProfession())
                        .role(user.get().getRole().toString())
                        .identityNumber(user.get().getIdentityNumber())
                        .build();
            }catch (Exception e){
                throw new UserManagerException(ErrorType.USER_NOT_UPDATED);
            }
        }else{
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
    }

    public List<SummaryResponseDto> findAllColleague(Long companyid) {
        Optional<List<User>> users = userRepository.findAllOptionalByCompanyid(companyid);
        return users.get().stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }

    public DetailResponseDto findByIdUser(Long id) {
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()){
            return DetailResponseDto.builder()
                    .id(user.get().getId())
                    .authid(user.get().getAuthid())
                    .name(user.get().getName())
                    .middleName(user.get().getMiddleName())
                    .surname(user.get().getSurname())
                    .secondSurname(user.get().getSecondSurname())
                    .email(user.get().getEmail())
                    .phone(user.get().getPhone())
                    .address(user.get().getAddress())
                    .photo(user.get().getPhoto())
                    .dob(user.get().getDob())
                    .placeOfBirth(user.get().getPlaceOfBirth())
                    .joinDate(user.get().getJoinDate())
                    .department(user.get().getDepartment())
                    .profession(user.get().getProfession())
                    .role(user.get().getRole().toString())
                    .identityNumber(user.get().getIdentityNumber())
                    .build();
        }else {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
    }

    public  List<SummaryResponseDto> findAllManagerByCompanyid(Long companyid) {
        Optional<List<User>> users = userRepository.findAllOptionalByRoleAndCompanyid(ERole.MANAGER,companyid);
        return users.get().stream().map(x -> IUserMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }
}
