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
public class CreatePasswordResponseDto {
    private Long id;
    private String email;
    @Builder.Default
    private int code=300;

}
