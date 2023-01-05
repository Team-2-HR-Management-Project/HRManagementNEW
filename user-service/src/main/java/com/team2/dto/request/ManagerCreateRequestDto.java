package com.team2.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

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
    @NotNull
    @Size(min = 11, max = 11 ,message = "TC can be 11 characters")
    private Long identityNumber;
    private String company;
    private Long companyid;

}
