package com.team2.manager;

import com.team2.dto.response.DetailResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.team2.constants.ApiUrls.CREATE;
import static com.team2.constants.ApiUrls.DELETEBYID;

@FeignClient(url = "${myapplication.feign.user}/user",name = "user-service-user",decode404 = true)
public interface IUserManager {

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<DetailResponseDto> findById(@PathVariable Long id);

}
