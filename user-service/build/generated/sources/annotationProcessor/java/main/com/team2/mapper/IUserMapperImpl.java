package com.team2.mapper;

import com.team2.dto.request.ActivateUserRequestDto;
import com.team2.dto.request.CreateRequestDto;
import com.team2.dto.request.UpdateRequestDto;
import com.team2.dto.response.DetailResponseDto;
import com.team2.dto.response.SummaryResponseDto;
import com.team2.repository.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-29T11:59:53+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User toUser(CreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.surname( dto.getSurname() );
        user.identityNumber( dto.getIdentityNumber() );
        user.email( dto.getEmail() );
        user.role( dto.getRole() );
        user.authid( dto.getAuthid() );
        user.companyid( dto.getCompanyid() );

        return user.build();
    }

    @Override
    public User toUser(UpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.photo( dto.getPhoto() );
        user.phone( dto.getPhone() );
        user.address( dto.getAddress() );
        user.authid( dto.getAuthid() );

        return user.build();
    }

    @Override
    public SummaryResponseDto toSummaryResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        SummaryResponseDto.SummaryResponseDtoBuilder summaryResponseDto = SummaryResponseDto.builder();

        summaryResponseDto.id( user.getId() );
        summaryResponseDto.name( user.getName() );
        summaryResponseDto.surname( user.getSurname() );
        summaryResponseDto.email( user.getEmail() );
        summaryResponseDto.phone( user.getPhone() );
        summaryResponseDto.address( user.getAddress() );
        summaryResponseDto.department( user.getDepartment() );
        summaryResponseDto.profession( user.getProfession() );
        summaryResponseDto.photo( user.getPhoto() );
        if ( user.getRole() != null ) {
            summaryResponseDto.role( user.getRole().name() );
        }

        return summaryResponseDto.build();
    }

    @Override
    public DetailResponseDto toDetailResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        DetailResponseDto.DetailResponseDtoBuilder detailResponseDto = DetailResponseDto.builder();

        detailResponseDto.id( user.getId() );
        detailResponseDto.authid( user.getAuthid() );
        detailResponseDto.name( user.getName() );
        detailResponseDto.surname( user.getSurname() );
        detailResponseDto.email( user.getEmail() );
        detailResponseDto.phone( user.getPhone() );
        detailResponseDto.address( user.getAddress() );
        detailResponseDto.department( user.getDepartment() );
        detailResponseDto.profession( user.getProfession() );
        detailResponseDto.photo( user.getPhoto() );
        detailResponseDto.middleName( user.getMiddleName() );
        detailResponseDto.secondSurname( user.getSecondSurname() );
        detailResponseDto.dob( user.getDob() );
        detailResponseDto.placeOfBirth( user.getPlaceOfBirth() );
        detailResponseDto.identityNumber( user.getIdentityNumber() );
        detailResponseDto.joinDate( user.getJoinDate() );
        if ( user.getRole() != null ) {
            detailResponseDto.role( user.getRole().name() );
        }

        return detailResponseDto.build();
    }

    @Override
    public User toUser(ActivateUserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.photo( dto.getPhoto() );
        user.middleName( dto.getMiddleName() );
        user.secondSurname( dto.getSecondSurname() );
        user.dob( dto.getDob() );
        user.placeOfBirth( dto.getPlaceOfBirth() );
        user.joinDate( dto.getJoinDate() );
        user.department( dto.getDepartment() );
        user.profession( dto.getProfession() );
        user.phone( dto.getPhone() );
        user.address( dto.getAddress() );
        user.authid( dto.getAuthid() );

        return user.build();
    }
}
