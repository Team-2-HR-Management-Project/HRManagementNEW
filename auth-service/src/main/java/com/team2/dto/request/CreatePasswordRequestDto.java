package com.team2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreatePasswordRequestDto implements Serializable {



    @Email(message = "Invalid Email ")
    @NotBlank
    private String email;
    @NotBlank
    private String temppassword;
    @NotBlank
    private String password;
    private Long id;



}
