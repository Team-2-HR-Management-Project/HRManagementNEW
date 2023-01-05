package com.team2.mapper;

import com.team2.dto.request.CreateLeaveRequestDto;
import com.team2.dto.response.LeaveResponseDto;
import com.team2.repository.entity.Leave;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T11:10:15+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ILeaveMapperImpl implements ILeaveMapper {

    @Override
    public Leave toLeave(CreateLeaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Leave.LeaveBuilder leave = Leave.builder();

        leave.managerid( dto.getManagerid() );
        leave.employeeid( dto.getEmployeeid() );
        leave.message( dto.getMessage() );
        leave.startDate( dto.getStartDate() );
        leave.endDate( dto.getEndDate() );
        leave.days( dto.getDays() );
        leave.type( dto.getType() );
        leave.authid( dto.getAuthid() );

        return leave.build();
    }

    @Override
    public LeaveResponseDto toLeaveResponseDto(Leave leave) {
        if ( leave == null ) {
            return null;
        }

        LeaveResponseDto.LeaveResponseDtoBuilder leaveResponseDto = LeaveResponseDto.builder();

        leaveResponseDto.id( leave.getId() );
        leaveResponseDto.authid( leave.getAuthid() );
        leaveResponseDto.managerid( leave.getManagerid() );
        leaveResponseDto.employeeid( leave.getEmployeeid() );
        leaveResponseDto.message( leave.getMessage() );
        leaveResponseDto.startDate( leave.getStartDate() );
        leaveResponseDto.endDate( leave.getEndDate() );
        leaveResponseDto.days( leave.getDays() );
        leaveResponseDto.creationDate( leave.getCreationDate() );
        leaveResponseDto.updateDate( leave.getUpdateDate() );
        leaveResponseDto.approvedDate( leave.getApprovedDate() );
        leaveResponseDto.type( leave.getType() );
        leaveResponseDto.status( leave.getStatus() );

        return leaveResponseDto.build();
    }

    @Override
    public List<LeaveResponseDto> toLeaveResponseDtoList(List<Leave> leaveList) {
        if ( leaveList == null ) {
            return null;
        }

        List<LeaveResponseDto> list = new ArrayList<LeaveResponseDto>( leaveList.size() );
        for ( Leave leave : leaveList ) {
            list.add( toLeaveResponseDto( leave ) );
        }

        return list;
    }
}
