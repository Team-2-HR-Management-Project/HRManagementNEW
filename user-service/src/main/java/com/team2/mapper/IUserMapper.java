package com.team2.mapper;

import com.team2.dto.request.ActivateUserRequestDto;
import com.team2.dto.request.CreateRequestDto;
import com.team2.dto.request.UpdateRequestDto;
import com.team2.dto.response.DetailResponseDto;
import com.team2.dto.response.SummaryResponseDto;
import com.team2.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final CreateRequestDto dto);
    User toUser(final UpdateRequestDto dto);
    SummaryResponseDto toSummaryResponseDto(final User user);
    DetailResponseDto toDetailResponseDto(final User user);
    User toUser(final ActivateUserRequestDto dto);
}
