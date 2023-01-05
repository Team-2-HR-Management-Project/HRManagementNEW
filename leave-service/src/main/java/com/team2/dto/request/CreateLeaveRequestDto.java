package com.team2.dto.request;

import com.team2.repository.enums.EStatus;
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
public class CreateLeaveRequestDto implements Serializable {

    private Long authid;
    private Long managerid;
    private Long employeeid;
    private String message;
    private Long startDate;
    private Long endDate;
    private Integer days;
    private EType type;


}
