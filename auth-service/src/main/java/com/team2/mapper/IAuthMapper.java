package com.team2.mapper;

import com.team2.dto.request.RegisterRequestDto;
import com.team2.dto.response.LoginResponseDto;
import com.team2.dto.response.RegisterResponseDto;
import com.team2.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAuthMapper {

    IAuthMapper INSTANCE= Mappers.getMapper(IAuthMapper.class);

    Auth toAuth(final RegisterRequestDto dto);
    RegisterResponseDto toRegisterResponseDto(final Auth auth);

    LoginResponseDto toLoginResponseDto(final Auth auth);


}
