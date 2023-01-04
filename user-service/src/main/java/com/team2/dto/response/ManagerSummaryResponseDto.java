package com.team2.dto.response;

import com.team2.repository.enums.EDepartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerSummaryResponseDto {

    private Long id;
    private Long userid;
    private Long managerid;
    private Long companyid;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String company;
    private String profession;
    private String photo;
    private String role;
}
