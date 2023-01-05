package com.team2.repository.entity;

import com.team2.repository.enums.EDepartment;
import javax.persistence.*;

import com.team2.repository.enums.ERole;
import com.team2.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    private String name;
    private String middleName;
    private String surname;
    private String secondSurname;
    private Long dob;
    private String placeOfBirth;

    private Long identityNumber;
    private Long joinDate;
    @Enumerated(EnumType.STRING)
    private EDepartment department;
    private String profession;
    private String email;
    private String phone;
    private String address;
    private Long resignDate;
    @Enumerated(EnumType.STRING)
    private ERole role;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;
    private Long authid;
    private Long companyid;
    private String company;

}
