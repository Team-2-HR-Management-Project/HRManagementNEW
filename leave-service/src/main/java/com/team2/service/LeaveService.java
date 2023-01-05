package com.team2.service;

import com.team2.dto.request.CreateLeaveRequestDto;
import com.team2.dto.request.NotifyMailRequestDto;
import com.team2.dto.request.UpdateLeaveRequestDto;
import com.team2.dto.response.DetailResponseDto;
import com.team2.dto.response.LeaveResponseDto;
import com.team2.exception.ErrorType;
import com.team2.exception.LeaveManagerException;
import com.team2.manager.IEmailManager;
import com.team2.manager.IUserManager;
import com.team2.mapper.ILeaveMapper;
import com.team2.repository.ILeaveRepository;
import com.team2.repository.entity.Leave;
import com.team2.repository.enums.EStatus;
import com.team2.utility.JwtTokenManager;
import com.team2.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeaveService extends ServiceManager<Leave, Long> {

    private final ILeaveRepository leaveRepository;
    private final IUserManager userManager;
    private final IEmailManager emailManager;

    private final JwtTokenManager jwtTokenManager;
    public LeaveService(ILeaveRepository leaveRepository,  JwtTokenManager jwtTokenManager,IUserManager userManager,IEmailManager emailManager) {
        super(leaveRepository);
        this.leaveRepository = leaveRepository;
        this.jwtTokenManager=jwtTokenManager;
        this.userManager=userManager;
        this.emailManager=emailManager;
    }

    public LeaveResponseDto createLeave(CreateLeaveRequestDto dto) {
        try{
            Leave leave = ILeaveMapper.INSTANCE.toLeave(dto);
            leave.setCreationDate(System.currentTimeMillis());
            save(leave);

            emailManager.notifymail(NotifyMailRequestDto.builder()
                    .email(userManager.findById(dto.getManagerid()).getBody().getEmail())
                    .message(
                            "Please check your employee leave list since you have new notification. "+
                        userManager.findById(dto.getEmployeeid()).getBody().getName() +" "+ userManager.findById(dto.getEmployeeid()).getBody().getSurname() +
                        " has requested "+ dto.getType() +" type leave for "+ dto.getDays() +". Message ...: "+ dto.getMessage()
                    )
                            .subject("Notification: New Leave Request")
                    .build());
            return ILeaveMapper.INSTANCE.toLeaveResponseDto(leave);
        }catch (Exception e){
            throw new LeaveManagerException(ErrorType.LEAVE_NOT_CREATED);
        }
    }

    public LeaveResponseDto updateLeave(UpdateLeaveRequestDto dto) {
        Optional<Leave> leave=findById(dto.getId());
        if(leave.isPresent()){
            leave.get().setMessage(dto.getMessage());
            leave.get().setStartDate(dto.getStartDate());
            leave.get().setEndDate(dto.getEndDate());
            leave.get().setDays(dto.getDays());
            leave.get().setType(dto.getType());
            leave.get().setUpdateDate(System.currentTimeMillis());
            save(leave.get());
            return ILeaveMapper.INSTANCE.toLeaveResponseDto(leave.get());
        }else{
            throw new LeaveManagerException((ErrorType.LEAVE_NOT_FOUND));
        }
    }

    public List<LeaveResponseDto> getLeaves(Long managerid) {
        Optional<List<Leave>> leaves=leaveRepository.findAllOptionalByManagerid(managerid);
        if(leaves.isPresent()){
            List<LeaveResponseDto> leaveResponseDtos=ILeaveMapper.INSTANCE.toLeaveResponseDtoList(leaves.get());

            return leaveResponseDtos.stream().map(x-> {
                DetailResponseDto detailDto=userManager.findById(x.getEmployeeid()).getBody();
                x.setName(detailDto.getName());
                x.setSurname(detailDto.getSurname());
                x.setPhoto(detailDto.getPhoto());
                x.setRole(detailDto.getRole());
                x.setDepartment(detailDto.getDepartment());
                x.setProfession(detailDto.getProfession());
                return x;

            }).collect(Collectors.toList());
        }else{
            throw new LeaveManagerException((ErrorType.LEAVE_NOT_FOUND));
        }
    }

    public List<LeaveResponseDto> getMyLeaves(Long authid) {
        Optional<List<Leave>> leaves=leaveRepository.findAllOptionalByAuthid(authid);
        if(leaves.isPresent()){
            List<LeaveResponseDto> leaveResponseDtos=ILeaveMapper.INSTANCE.toLeaveResponseDtoList(leaves.get());

           return leaveResponseDtos.stream().map(x-> {
                DetailResponseDto detailDto=userManager.findById(x.getEmployeeid()).getBody();
                x.setName(detailDto.getName());
                x.setSurname(detailDto.getSurname());
                x.setPhoto(detailDto.getPhoto());
                x.setRole(detailDto.getRole());
                x.setDepartment(detailDto.getDepartment());
                x.setProfession(detailDto.getProfession());
                return x;

            }).collect(Collectors.toList());

        }else{
            throw new LeaveManagerException((ErrorType.LEAVE_NOT_FOUND));
        }
    }

    public LeaveResponseDto approveLeave(Long id) {
        Optional<Leave> leave=findById(id);
        if(leave.isPresent()){
            leave.get().setStatus(EStatus.APPROVED);
            leave.get().setApprovedDate(System.currentTimeMillis());
            save(leave.get());
            emailManager.notifymail(NotifyMailRequestDto.builder()
                    .email(userManager.findById(leave.get().getEmployeeid()).getBody().getEmail())
                    .message(
                            "Please check your leave status since you have new notification. It has been APPROVED by "+
                                    userManager.findById(leave.get().getManagerid()).getBody().getName() +" "+ userManager.findById(leave.get().getManagerid()).getBody().getSurname()
                    )
                    .subject("Notification: Leave Request")
                    .build());
            return ILeaveMapper.INSTANCE.toLeaveResponseDto(leave.get());
        }else{
            throw new LeaveManagerException((ErrorType.LEAVE_NOT_FOUND));
        }
    }

    public LeaveResponseDto rejectLeave(Long id) {
        Optional<Leave> leave=findById(id);
        if(leave.isPresent()){
            leave.get().setStatus(EStatus.REJECTED);
            leave.get().setApprovedDate(System.currentTimeMillis());
            save(leave.get());
            emailManager.notifymail(NotifyMailRequestDto.builder()
                    .email(userManager.findById(leave.get().getEmployeeid()).getBody().getEmail())
                    .message(
                            "Please check your leave status since you have new notification. It has been REJECTED by "+
                                    userManager.findById(leave.get().getManagerid()).getBody().getName() +" "+ userManager.findById(leave.get().getManagerid()).getBody().getSurname()
                    )
                    .subject("Notification: Leave Request")
                    .build());
            return ILeaveMapper.INSTANCE.toLeaveResponseDto(leave.get());
        }else{
            throw new LeaveManagerException((ErrorType.LEAVE_NOT_FOUND));
        }
    }


}
