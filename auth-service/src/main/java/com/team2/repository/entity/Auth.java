package com.team2.repository.entity;
import com.team2.repository.enums.ERole;
import javax.persistence.*;

import com.team2.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String temppassword;
    private String email;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role=ERole.EMPLOYEE;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;

}
