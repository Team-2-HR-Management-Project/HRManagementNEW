package com.team2.dto.request;

import com.team2.repository.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateLeaveRequestDto implements Serializable {

    private Long id;
    private Long authid;
    private Long managerid;
    private Long employeeid;
    private String message;
    @NotBlank
    private Long startDate;
    @NotBlank
    private Long endDate;
    private Integer days;
    private EType type;


}
