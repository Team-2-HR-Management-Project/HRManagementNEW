package com.team2.mapper;

import com.team2.dto.request.RegisterRequestDto;
import com.team2.dto.response.LoginResponseDto;
import com.team2.dto.response.RegisterResponseDto;
import com.team2.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-24T21:21:28+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth toAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.password( dto.getPassword() );
        auth.email( dto.getEmail() );

        return auth.build();
    }

    @Override
    public RegisterResponseDto toRegisterResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.id( auth.getId() );
        registerResponseDto.email( auth.getEmail() );

        return registerResponseDto.build();
    }

    @Override
    public LoginResponseDto toLoginResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        LoginResponseDto.LoginResponseDtoBuilder loginResponseDto = LoginResponseDto.builder();

        loginResponseDto.id( auth.getId() );
        loginResponseDto.email( auth.getEmail() );
        loginResponseDto.role( auth.getRole() );

        return loginResponseDto.build();
    }
}
