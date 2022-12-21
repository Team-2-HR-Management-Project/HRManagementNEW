//package com.team2.controller;
//
//import com.team2.dto.request.*;
//import com.team2.dto.response.ManagerDetailResponseDto;
//import com.team2.dto.response.ManagerSummaryResponseDto;
//import com.team2.repository.entity.Manager;
//import com.team2.service.ManagerService;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//import static com.team2.constants.ApiUrls.*;
//
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(MANAGER)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class ManagerController {
//
//    private final ManagerService managerService;
//
//     @PostMapping(CREATE)
//    public ResponseEntity<Boolean> createManager(@RequestBody @Valid ManagerCreateRequestDto dto){
//        return ResponseEntity.ok(managerService.createManager(dto));
//    }
//
//    /*
//        @PutMapping(UPDATE)
//    public ResponseEntity<DetailResponseDto> updateUser(@RequestBody UpdateRequestDto dto){
//        return ResponseEntity.ok(userService.updateUser(dto));
//    }
//     */
//
//    @GetMapping(FINDALL)
//    public ResponseEntity<List<ManagerSummaryResponseDto>> findAllManagerSummary(){
//        return ResponseEntity.ok(managerService.findAllManagerSummary());
//    }
//
//    @GetMapping(SEE_DETAIL)
//    public ResponseEntity<ManagerDetailResponseDto> seeManagerDetail(@PathVariable Long userid){
//         return ResponseEntity.ok(managerService.seeManagerDetail(userid));
//    }
//
//    /*
//    @PutMapping(ACTIVATE)
//    public  ResponseEntity<Boolean> activateUser(@RequestBody ActivateUserRequestDto dto){
//         return ResponseEntity.ok(userService.activateUser(dto));
//    }
//    */
//
//    @GetMapping(FINDBYID)
//    public ResponseEntity<Manager> getById(@RequestBody @PathVariable Long id) {
//        return ResponseEntity.ok(managerService.getById(id));
//    }
//
//}
