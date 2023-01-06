package com.team2.dto.response;

import com.team2.repository.enums.EDepartment;
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
public class DetailResponseDto {

    private Long id;
    private Long authid;
    private Long companyid;
    private String company;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private EDepartment department;
    private String profession;
    private String photo;
    private String middleName;
    private String secondSurname;
    private String dob;
    private String placeOfBirth;
    private Long identityNumber;
    private String joinDate;
    private String role;
}
