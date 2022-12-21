package com.team2.manager;

import com.team2.dto.request.CreateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.team2.constants.ApiUrls.*;
@FeignClient(url = "${myapplication.feign.user}/user",name = "user-service-user",decode404 = true)
public interface IUserManager {

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long authid);

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid CreateRequestDto dto);

}
