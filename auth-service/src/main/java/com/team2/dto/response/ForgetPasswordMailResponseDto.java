package com.team2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ForgetPasswordMailResponseDto {
    private Long id;
    private String email;
    private String temppassword;
}
