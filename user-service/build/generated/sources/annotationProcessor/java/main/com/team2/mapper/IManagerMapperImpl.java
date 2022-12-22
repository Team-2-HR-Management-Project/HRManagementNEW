package com.team2.mapper;

import com.team2.dto.request.CreateRequestDto;
import com.team2.dto.request.ManagerCreateRequestDto;
import com.team2.dto.response.ManagerDetailResponseDto;
import com.team2.dto.response.ManagerSummaryResponseDto;
import com.team2.repository.entity.Manager;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T10:27:07+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IManagerMapperImpl implements IManagerMapper {

    @Override
    public Manager toManager(ManagerCreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Manager.ManagerBuilder manager = Manager.builder();

        manager.company( dto.getCompany() );

        return manager.build();
    }

    @Override
    public ManagerCreateRequestDto toManagerCreateRequestDto(CreateRequestDto createRequestDto) {
        if ( createRequestDto == null ) {
            return null;
        }

        ManagerCreateRequestDto.ManagerCreateRequestDtoBuilder managerCreateRequestDto = ManagerCreateRequestDto.builder();

        managerCreateRequestDto.email( createRequestDto.getEmail() );
        managerCreateRequestDto.name( createRequestDto.getName() );
        managerCreateRequestDto.surname( createRequestDto.getSurname() );
        managerCreateRequestDto.identityNumber( createRequestDto.getIdentityNumber() );

        return managerCreateRequestDto.build();
    }

    @Override
    public CreateRequestDto toCreateRequestDto(ManagerCreateRequestDto managerCreateRequestDto) {
        if ( managerCreateRequestDto == null ) {
            return null;
        }

        CreateRequestDto.CreateRequestDtoBuilder createRequestDto = CreateRequestDto.builder();

        createRequestDto.email( managerCreateRequestDto.getEmail() );
        createRequestDto.name( managerCreateRequestDto.getName() );
        createRequestDto.surname( managerCreateRequestDto.getSurname() );
        createRequestDto.identityNumber( managerCreateRequestDto.getIdentityNumber() );

        return createRequestDto.build();
    }

    @Override
    public ManagerSummaryResponseDto toManagerSummaryResponseDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerSummaryResponseDto.ManagerSummaryResponseDtoBuilder managerSummaryResponseDto = ManagerSummaryResponseDto.builder();

        managerSummaryResponseDto.id( manager.getId() );
        managerSummaryResponseDto.company( manager.getCompany() );

        return managerSummaryResponseDto.build();
    }

    @Override
    public ManagerDetailResponseDto toManagerDetailResponseDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerDetailResponseDto.ManagerDetailResponseDtoBuilder managerDetailResponseDto = ManagerDetailResponseDto.builder();

        managerDetailResponseDto.id( manager.getId() );
        managerDetailResponseDto.company( manager.getCompany() );

        return managerDetailResponseDto.build();
    }
}
