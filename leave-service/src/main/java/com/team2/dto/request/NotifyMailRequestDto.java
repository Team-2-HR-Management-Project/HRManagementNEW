package com.team2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotifyMailRequestDto {
    private String message;
    private String email;
    private String subject;
}
