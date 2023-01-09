package com.team2.manager;

import com.team2.dto.response.DetailResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${myapplication.feign.user}/user",name = "user-service-user",decode404 = true)
public interface IUserManager {

    @GetMapping("/findbyuserid/{id}")
    public ResponseEntity<DetailResponseDto> findById(@PathVariable Long id);

}
