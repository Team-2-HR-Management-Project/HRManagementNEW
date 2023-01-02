package com.team2.dto.request;

import com.team2.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForgetPasswordMailRequestDto implements Serializable {

    @NotBlank(message = "Email is mandatory")
    @Column(unique=true)
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private ERole role;
    private Long companyid;
}
