package com.team2.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class RegisterByMailResponseDto  {
    private Long id;
    private String email;
    private String temppassword;
}
