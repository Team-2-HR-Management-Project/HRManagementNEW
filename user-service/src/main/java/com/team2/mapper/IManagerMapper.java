package com.team2.mapper;

import com.team2.dto.request.CreateRequestDto;
import com.team2.dto.request.ManagerCreateRequestDto;

import com.team2.dto.response.ManagerDetailResponseDto;
import com.team2.dto.response.ManagerSummaryResponseDto;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IManagerMapper {

    IManagerMapper INSTANCE = Mappers.getMapper(IManagerMapper.class);



}
