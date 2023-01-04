package com.team2.dto.response;

import com.team2.repository.enums.EDepartment;
import com.team2.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private EDepartment department;
    private String profession;
    private String photo;
    private String role;
    private String company;
    private Long companyid;
}
