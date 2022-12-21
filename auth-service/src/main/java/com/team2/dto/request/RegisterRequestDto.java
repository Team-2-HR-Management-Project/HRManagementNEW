package com.team2.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {

    @NotBlank
    @Size(min = 8, max = 32 ,message = "Password can be between 8 to 32 characters")
    private String password;
    @Email(message = "Invalid Email ")
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    // Note validation bakılacak
    private Long identityNumber;
    private  String adminCode;
}
