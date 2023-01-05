package com.team2.dto.request;

import com.team2.repository.enums.EDepartment;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.team2.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRequestDto {

    private Long authid;
    private String email;
    private String name;
    private String surname;
    @NotNull
    @Size(min = 11, max = 11 ,message = "TC can be 11 characters")
    private Long identityNumber;
    private ERole role;
    private Long companyid;
}
