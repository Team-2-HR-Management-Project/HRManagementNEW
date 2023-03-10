package team2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.dto.request.ActivateCompanyRequestDto;
import team2.dto.request.CreateRequestDto;
import team2.dto.request.FindByToken;
import team2.dto.request.UpdateRequestDto;
import team2.dto.response.CompanyDetailResponseDto;
import team2.dto.response.SummaryResponseDto;
import team2.repository.entity.Company;
import team2.service.CompanyService;

import javax.validation.Valid;
import java.util.List;


import static team2.constants.ApiUrls.*;



@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(CREATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid CreateRequestDto dto){
        return ResponseEntity.ok(companyService.createCompany(dto));
    }

    @PutMapping(UPDATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CompanyDetailResponseDto> updateUser(@RequestBody UpdateRequestDto dto){
        return ResponseEntity.ok(companyService.updateCompany(dto));
    }

    @GetMapping(FINDALL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SummaryResponseDto>> findAllSummary(){
        return ResponseEntity.ok(companyService.findAllSummary());
    }
    @GetMapping(SEE_DETAIL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CompanyDetailResponseDto> seeDetail(@PathVariable Long id){
         return ResponseEntity.ok(companyService.seeDetail(id));
    }

    @DeleteMapping(DELETE_BY_ID)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.deleteUser(id));
    }

    @PutMapping(ACTIVATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public  ResponseEntity<Boolean> activateUser(@RequestBody ActivateCompanyRequestDto dto){
         return ResponseEntity.ok(companyService.activateUser(dto));
    }

    @GetMapping(FINDBYID)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CompanyDetailResponseDto> getById(@RequestBody @PathVariable Long id) {
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PostMapping("/findbytoken")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CompanyDetailResponseDto> findbyToken(@RequestBody FindByToken token) {

        return ResponseEntity.ok(companyService.findByToken(token.getToken()));

    }
}
