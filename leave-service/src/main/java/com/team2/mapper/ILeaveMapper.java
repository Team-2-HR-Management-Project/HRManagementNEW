package com.team2.mapper;


import com.team2.dto.request.CreateLeaveRequestDto;
import com.team2.dto.response.LeaveResponseDto;
import com.team2.repository.entity.Leave;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ILeaveMapper {

    ILeaveMapper INSTANCE = Mappers.getMapper(ILeaveMapper.class);

    Leave toLeave(final CreateLeaveRequestDto dto);
    LeaveResponseDto toLeaveResponseDto(final Leave leave);
    List<LeaveResponseDto> toLeaveResponseDtoList(final List<Leave> leaveList);
}
