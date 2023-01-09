package com.team2.dto.response;

import com.team2.repository.enums.EDepartment;
import com.team2.repository.enums.EStatus;
import com.team2.repository.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseResponseDto implements Serializable {
    private Long id;
    private Long managerid;
    private Long employeeid;
    private Long authid;
    private Double amount;
    private String currency;
    private Long createDate;
    private String responseDate;
    private String file;
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
    private String dob;
    private String placeOfBirth;
    private Long identityNumber;
    private String joinDate;
    private String role;
}
