package com.team2.dto.response;

import com.team2.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginResponseDto {
    private Long id;
    private String email;
    private ERole role;
    private String token;
    @Builder.Default
    private int code=400;
}
