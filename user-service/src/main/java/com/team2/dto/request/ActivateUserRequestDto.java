package com.team2.dto.request;

import com.team2.repository.enums.EDepartment;
import com.team2.repository.enums.EStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import com.team2.repository.enums.EDepartment;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivateUserRequestDto {


    private String phone;
    private String address;
    private EDepartment department;
    private String profession;
    private String photo;
    private String middleName;
    private String secondSurname;
    private String dob;
    private String placeOfBirth;
    private String joinDate;
    private Long authid;


}
