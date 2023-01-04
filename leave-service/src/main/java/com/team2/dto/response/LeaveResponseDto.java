package com.team2.dto.response;

import com.team2.repository.enums.EDepartment;
import com.team2.repository.enums.EStatus;
import com.team2.repository.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveResponseDto implements Serializable {

    private Long id;
    private Long authid;
    private Long managerid;
    private Long employeeid;
    private String message;
    private Long startDate;
    private Long endDate;
    private Integer days;
    private Long creationDate;
    private Long updateDate;
    private Long approvedDate;
    private EType type;
    private EStatus status;

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
    private Long dob;
    private String placeOfBirth;
    private Long identityNumber;
    private Long joinDate;
    private String role;

}
