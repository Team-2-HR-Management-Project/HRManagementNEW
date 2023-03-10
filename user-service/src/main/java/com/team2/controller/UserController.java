package com.team2.controller;

import com.team2.dto.request.*;
import com.team2.dto.response.DetailResponseDto;
import com.team2.dto.response.SummaryResponseDto;
import com.team2.repository.entity.User;
import com.team2.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.team2.constants.ApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

     @PostMapping(CREATE)
     @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid CreateRequestDto dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PutMapping(UPDATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DetailResponseDto> updateUser(@RequestBody @Valid UpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateUser(dto));
    }
    @PutMapping(UPDATEALL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DetailResponseDto> updateAllUser(@RequestBody @Valid UpdateAllRequestDto dto){
        return ResponseEntity.ok(userService.updateAllUser(dto));
    }

    @GetMapping(FINDALL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SummaryResponseDto>> findAllSummary(){
        return ResponseEntity.ok(userService.findAllSummary());
    }

    @GetMapping(FINDALL_MANAGER)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SummaryResponseDto>> findAllManager(){
        return ResponseEntity.ok(userService.findAllManager());
    }
    @GetMapping("/findallmanagerbycompanyid/{companyid}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SummaryResponseDto>> findAllManagerByCompanyid(@PathVariable Long companyid){
        return ResponseEntity.ok(userService.findAllManagerByCompanyid(companyid));
    }

    @GetMapping(FINDALL_EMPLOYEE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SummaryResponseDto>> findAllEmployee(@PathVariable Long companyid){
        return ResponseEntity.ok(userService.findAllEmployee(companyid));
    }
    @GetMapping(FINDALL_COLLEAGUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<SummaryResponseDto>> findAllColleague(@PathVariable Long companyid){
        return ResponseEntity.ok(userService.findAllColleague(companyid));
    }
    /*
    @GetMapping(FINDALL_MY_EMPLOYEE)
    public ResponseEntity<List<SummaryResponseDto>> findAllMyEmployee(Long companyid){
        return ResponseEntity.ok(userService.findAllMyEmployee(companyid));
    }
    */
    @GetMapping(SEE_DETAIL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DetailResponseDto> seeDetail(@PathVariable Long authid){
         return ResponseEntity.ok(userService.seeDetail(authid));
    }
    @GetMapping("/findbyuserid/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DetailResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findByIdUser(id));
    }

    @DeleteMapping(DELETEBYID)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long authid) {
        return ResponseEntity.ok(userService.deleteUser(authid));
    }

    @PutMapping(ACTIVATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public  ResponseEntity<Boolean> activateUser(@RequestBody ActivateUserRequestDto dto){
         return ResponseEntity.ok(userService.activateUser(dto));
    }

    @GetMapping(FINDBYID)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<User> getById(@RequestBody @PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
    @PostMapping("/findbytoken")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DetailResponseDto> findbyToken(@RequestBody FindByToken token) {

        return ResponseEntity.ok(userService.findByToken(token.getToken()));

    }
    @GetMapping("/findbytokenn/{token}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DetailResponseDto> findbyToken2(@PathVariable String token) {

        return ResponseEntity.ok(userService.findByToken(token));

    }
}
