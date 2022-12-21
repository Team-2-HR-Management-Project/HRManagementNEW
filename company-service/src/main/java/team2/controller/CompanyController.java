package team2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.dto.request.ActivateCompanyRequestDto;
import team2.dto.request.CreateRequestDto;
import team2.dto.request.FindByToken;
import team2.dto.request.UpdateRequestDto;
import team2.dto.response.DetailResponseDto;
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
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid CreateRequestDto dto){
        return ResponseEntity.ok(companyService.createCompany(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<DetailResponseDto> updateUser(@RequestBody UpdateRequestDto dto){
        return ResponseEntity.ok(companyService.updateCompany(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<SummaryResponseDto>> findAllSummary(){
        return ResponseEntity.ok(companyService.findAllSummary());
    }
    @GetMapping(SEE_DETAIL)
    public ResponseEntity<DetailResponseDto> seeDetail(@PathVariable Long id){
         return ResponseEntity.ok(companyService.seeDetail(id));
    }

    @DeleteMapping(DELETE_BY_ID)
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.deleteUser(id));
    }

    @PutMapping(ACTIVATE)
    public  ResponseEntity<Boolean> activateUser(@RequestBody ActivateCompanyRequestDto dto){
         return ResponseEntity.ok(companyService.activateUser(dto));
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<Company> getById(@RequestBody @PathVariable Long id) {
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PostMapping("/findbytoken")
    public ResponseEntity<DetailResponseDto> findbyToken(@RequestBody FindByToken token) {

        return ResponseEntity.ok(companyService.findByToken(token.getToken()));

    }
}
