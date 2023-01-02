package com.team2.dto.response;

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

}
