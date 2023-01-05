package com.team2.manager;


import com.team2.dto.request.NotifyMailRequestDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8099/api/v1/email",name = "email-service",decode404 = true)
public interface IEmailManager {

    @PostMapping("/notifymail")
    public void notifymail(@RequestBody NotifyMailRequestDto dto);
}
