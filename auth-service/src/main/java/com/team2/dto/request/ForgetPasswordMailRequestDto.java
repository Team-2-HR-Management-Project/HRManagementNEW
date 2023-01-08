package com.team2.dto.request;

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
}
