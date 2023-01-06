package com.team2.repository.entity;


import com.team2.repository.enums.EStatus;
import com.team2.repository.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_leave")
public class Leave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long managerid;
    private Long employeeid;
    private String message;
    private String startDate;
    private String endDate;
    private Integer days;
    private Long creationDate;
    private Long updateDate;
    private Long approvedDate;
    @Enumerated(EnumType.STRING)
    private EType type;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;
    private Long authid;


}
