package com.team2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerCreateRequestDto {
    private Long userid;
    //private Long managerid;
    private String email;
    private String name;
    private String surname;
    private Long identityNumber;
    private String company;

}
