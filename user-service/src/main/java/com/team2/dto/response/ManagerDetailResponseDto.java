package com.team2.dto.response;

import com.team2.repository.enums.EDepartment;
import com.team2.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerDetailResponseDto {

    private Long id;
    private Long userid;
    private Long managerid;
    private Long companyid;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String profession;
    private String photo;
    private String middleName;
    private String secondSurname;
    private String company;
    private Long dob;
    private String placeOfBirth;
    private Long identityNumber;
    private Long joinDate;
    private Long resignDate;
    private String status;
    private String role;

}
