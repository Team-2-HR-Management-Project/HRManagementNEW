package com.team2.manager;

import com.team2.dto.request.ActivateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.team2.constants.ApiUrls.*;

@FeignClient(url = "${myapplication.feign.auth}/auth",name = "auth-service",decode404 = true)
public interface IAuthManager {



}
