package com.team2.dto.response;

import com.team2.repository.enums.EStatus;
import com.team2.repository.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveDetailResponseDto {

    private Long id;
    private Long managerid;
    private Long employeeid;
    private String message;
    private Long startDate;
    private Long endDate;
    private Integer days;
    private Long creationDate;
    private EType type;
    private EStatus status=EStatus.PENDING;
    private Long authid;
}
