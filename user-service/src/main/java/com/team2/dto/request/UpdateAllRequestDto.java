package com.team2.dto.request;

import com.team2.repository.enums.EDepartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAllRequestDto {
    private Long id;
    private Long authid;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String profession;
    private String photo;
    private String middleName;
    private String secondSurname;
    private Long dob;
    private String placeOfBirth;
    //@Size(min = 11, max = 11 ,message = "TC can be 11 characters")
    private Long identityNumber;
    private Long joinDate;
}
