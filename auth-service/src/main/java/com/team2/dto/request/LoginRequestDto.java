package com.team2.dto.request;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequestDto {
    @Email(message = "Invalid Email ")
    private String email;
    @Size(min = 8, max = 32 ,message = "Password can be between 8 to 31 characters")
    private String password;

}
