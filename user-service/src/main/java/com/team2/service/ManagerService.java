//package com.team2.service;
//
//
//import com.team2.dto.request.CreateRequestDto;
//import com.team2.dto.request.ManagerCreateRequestDto;
//
//import com.team2.dto.response.ManagerDetailResponseDto;
//import com.team2.dto.response.ManagerSummaryResponseDto;
//import com.team2.exception.ErrorType;
//import com.team2.exception.UserManagerException;
//import com.team2.mapper.IManagerMapper;
//import com.team2.mapper.IUserMapper;
//import com.team2.repository.IManagerRepository;
//import com.team2.repository.entity.Manager;
//import com.team2.repository.entity.User;
//import com.team2.utility.JwtTokenManager;
//import com.team2.utility.ServiceManager;
//
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class ManagerService extends ServiceManager<Manager, Long> {
//
//    private final IManagerRepository managerRepository;
//    private final UserService userService;
//    private final JwtTokenManager jwtTokenManager;
//    public ManagerService(IManagerRepository managerRepository, UserService userService, JwtTokenManager jwtTokenManager) {
//        super(managerRepository);
//        this.managerRepository = managerRepository;
//        this.userService=userService;
//        this.jwtTokenManager=jwtTokenManager;
//    }
//
////    public Boolean createManager(ManagerCreateRequestDto dto){
////        try{
////            Optional<User> user = userService.findById(dto.getUserid());
////            Optional<User> managerUser = userService.findById(dto.getManagerid());
////            Optional<Manager> managerDb = managerRepository
////                    .findOptionalByManagerIdAndUserId(dto.getManagerid(), user.get().getId());
////            Manager manager;
////            if (managerDb.isEmpty() && user.isPresent() && managerUser.isPresent()) {
////
////                manager = save(IManagerMapper.INSTANCE.toManager(dto));
////                user.get().getManagers().add(dto.getManagerid());
////
////                userService.save(user.get());
////                userService.save(managerUser.get());
////            }else{
////                throw new UserManagerException(ErrorType.USER_NOT_CREATED);
////            }
////            return true;
////        }catch (Exception e){
////            throw new UserManagerException(ErrorType.USER_NOT_CREATED);
////        }
////    }
//
//    public Boolean createManager(ManagerCreateRequestDto dto){
//
//        try{
//            userService.createUser(IManagerMapper.INSTANCE.toCreateRequestDto(dto));
//            save(IManagerMapper.INSTANCE.toManager(dto));
//            return true;
//        }catch (Exception e){
//            throw new UserManagerException(ErrorType.USER_NOT_CREATED);
//        }
//    }
//    /*
//
//    public DetailResponseDto updateUser(UpdateRequestDto dto){
//        Optional<User> user=userRepository.findOptionalByAuthid(dto.getAuthid());
//        if(user.isPresent()){
//            try{
//                user.get().setPhone(dto.getPhone());
//                user.get().setAddress(dto.getAddress());
//                user.get().setPhoto(dto.getPhoto());
//                save(user.get());
//                return IUserMapper.INSTANCE.toDetailResponseDto(user.get());
//            }catch (Exception e){
//                throw new UserManagerException(ErrorType.USER_NOT_UPDATED);
//            }
//        }else{
//            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
//        }
//    }
//
//    */
//    public List<ManagerSummaryResponseDto> findAllManagerSummary(){
//
//        List<Manager> managers = managerRepository.findAll();
//        return managers.stream().map(x -> IManagerMapper.INSTANCE.toManagerSummaryResponseDto(x))
//                .collect(Collectors.toList());
//    }
//
//    public ManagerDetailResponseDto seeManagerDetail(Long userid){
//
//        Optional<Manager> manager=managerRepository.findOptionalByUserid(userid);
//        if (manager.isPresent()){
//            return IManagerMapper.INSTANCE.toManagerDetailResponseDto(manager.get());
//        }else {
//            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
//        }
//    }
//
//    /*
//
//    public boolean activateUser(ActivateUserRequestDto dto) {
//        Optional<User> user=userRepository.findOptionalByAuthid(dto.getAuthid());
//        if(user.isPresent()){
//
//            user.get().setPhone(dto.getPhone());
//            user.get().setAddress(dto.getAddress());
//            user.get().setDepartment(dto.getDepartment());
//            user.get().setProfession(dto.getProfession());
//            user.get().setPhoto(dto.getPhoto());
//            user.get().setMiddleName(dto.getMiddleName());
//            user.get().setSecondSurname(dto.getSecondSurname());
//            user.get().setDob(dto.getDob());
//            user.get().setPlaceOfBirth(dto.getPlaceOfBirth());
//            user.get().setJoinDate(dto.getJoinDate());
//
//
//            save(user.get());
//
//            return true;
//        }else{
//            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
//        }
//    }
//*/
//
//    public Manager getById(Long id) {
//        Optional<Manager> manager = managerRepository.findOptionalByUserid(id);
//        if (manager.isPresent()) {
//            return manager.get();
//        } else {
//            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
//        }
//    }
//}//class
