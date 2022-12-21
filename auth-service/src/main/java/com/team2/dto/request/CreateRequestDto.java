package com.team2.dto.request;

import com.team2.repository.enums.EDepartment;
import com.team2.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRequestDto {


    private String email;
    private Long authid;
    private String name;
    private String surname;
    private Long identityNumber;
    private ERole role;

}
