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
    public ResponseEntity<Boolean> createUser(@RequestBody  CreateRequestDto dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<DetailResponseDto> updateUser(@RequestBody UpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateUser(dto));
    }
    @PutMapping(UPDATEALL)
    public ResponseEntity<DetailResponseDto> updateAllUser(@RequestBody UpdateAllRequestDto dto){
        return ResponseEntity.ok(userService.updateAllUser(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<SummaryResponseDto>> findAllSummary(){
        return ResponseEntity.ok(userService.findAllSummary());
    }

    @GetMapping(FINDALL_MANAGER)
    public ResponseEntity<List<SummaryResponseDto>> findAllManager(){
        return ResponseEntity.ok(userService.findAllManager());
    }

    @GetMapping(FINDALL_EMPLOYEE)
    public ResponseEntity<List<SummaryResponseDto>> findAllEmployee(@PathVariable Long companyid){
        return ResponseEntity.ok(userService.findAllEmployee(companyid));
    }
@GetMapping(FINDALL_COLLEAGUE)
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
    public ResponseEntity<DetailResponseDto> seeDetail(@PathVariable Long authid){
         return ResponseEntity.ok(userService.seeDetail(authid));
    }
    @GetMapping("/findbyuserid/{id}")
    public ResponseEntity<DetailResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findByIdUser(id));
    }

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long authid) {
        return ResponseEntity.ok(userService.deleteUser(authid));
    }

    @PutMapping(ACTIVATE)
    public  ResponseEntity<Boolean> activateUser(@RequestBody ActivateUserRequestDto dto){
         return ResponseEntity.ok(userService.activateUser(dto));
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<User> getById(@RequestBody @PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
    @GetMapping("/findbytoken")
    public ResponseEntity<DetailResponseDto> findbyToken(@RequestBody FindByToken token) {

        return ResponseEntity.ok(userService.findByToken(token.getToken()));

    }
    @GetMapping("/findbytokenn/{token}")
    public ResponseEntity<DetailResponseDto> findbyToken2(@PathVariable String token) {

        return ResponseEntity.ok(userService.findByToken(token));

    }
}
