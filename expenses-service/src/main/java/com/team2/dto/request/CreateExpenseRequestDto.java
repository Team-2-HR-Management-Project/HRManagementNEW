package com.team2.dto.request;

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
public class CreateExpenseRequestDto implements Serializable {
    private Long id;
    private Long managerid;
    private Long employeeid;
    private Long authid;
    private Double amount;
    private String currency;
    private String file;
    private EType type;

}
