package com.team2.manager;

import com.team2.dto.response.CompanyDetailResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static com.team2.constants.ApiUrls.FINDBYID;
@FeignClient(url = "${myapplication.feign.company}/company",name = "company-service",decode404 = true)
public interface ICompanyManager {
    @GetMapping(FINDBYID)
    public ResponseEntity<CompanyDetailResponseDto> getById(@RequestBody @PathVariable Long id);
}
