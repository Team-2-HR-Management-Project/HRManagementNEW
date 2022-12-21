package com.team2.manager;


import com.team2.dto.response.RegisterByMailResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8099/api/v1/email",name = "email-service",decode404 = true)
public interface IEmailManager {

    @PostMapping("/sendMail")
    public void sendMail( @RequestBody RegisterByMailResponseDto dto);
}
