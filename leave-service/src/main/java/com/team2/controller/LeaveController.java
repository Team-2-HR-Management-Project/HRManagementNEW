package com.team2.controller;


import com.team2.dto.request.CreateLeaveRequestDto;
import com.team2.dto.request.LeaveRequestDto;
import com.team2.dto.request.UpdateLeaveRequestDto;
import com.team2.dto.response.LeaveDetailResponseDto;
import com.team2.dto.response.LeaveResponseDto;
import com.team2.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.team2.constants.ApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(LEAVE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping(CREATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<LeaveResponseDto> createLeave(@RequestBody CreateLeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.createLeave(dto));
    }

    @PutMapping(UPDATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<LeaveResponseDto> updateLeave(@RequestBody UpdateLeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.updateLeave(dto));
    }

    @GetMapping(FINDALLLEAVES)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<LeaveResponseDto>> getLeaves(@PathVariable Long managerid){
        return ResponseEntity.ok(leaveService.getLeaves(managerid));
    }

    @GetMapping(FINDMYLEAVES)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<LeaveResponseDto>> getMyLeaves(@PathVariable Long authid){
        return ResponseEntity.ok(leaveService.getMyLeaves(authid));
    }

    @GetMapping(APPROVELEAVE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<LeaveResponseDto> approveLeave( @PathVariable Long id){
        return ResponseEntity.ok(leaveService.approveLeave(id));
    }

    @GetMapping(REJECTLEAVE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<LeaveResponseDto> rejectLeave( @PathVariable Long id){
        return ResponseEntity.ok(leaveService.rejectLeave(id));
    }

    @GetMapping(SEE_DETAIL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<LeaveDetailResponseDto> seeDetail(@PathVariable Long authid){
        return ResponseEntity.ok(leaveService.seeDetail(authid));
    }

    @PostMapping ("/seeleavedetail")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<LeaveResponseDto> seeLeaveDetail(@RequestBody LeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.seeLeaveDetail(dto.getId()));
    }

}
