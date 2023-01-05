package com.team2.controller;


import com.team2.dto.request.CreateLeaveRequestDto;
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
    public ResponseEntity<LeaveResponseDto> createLeave(@RequestBody CreateLeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.createLeave(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<LeaveResponseDto> updateLeave(@RequestBody UpdateLeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.updateLeave(dto));
    }

    @GetMapping(FINDALLLEAVES)
    public ResponseEntity<List<LeaveResponseDto>> getLeaves(@PathVariable Long managerid){
        return ResponseEntity.ok(leaveService.getLeaves(managerid));
    }

    @GetMapping(FINDMYLEAVES)
    public ResponseEntity<List<LeaveResponseDto>> getMyLeaves(@PathVariable Long authid){
        return ResponseEntity.ok(leaveService.getMyLeaves(authid));
    }

    @PostMapping(APPROVELEAVE)
    public ResponseEntity<LeaveResponseDto> approveLeave(@RequestBody @PathVariable Long id){
        return ResponseEntity.ok(leaveService.approveLeave(id));
    }

    @PostMapping(REJECTLEAVE)
    public ResponseEntity<LeaveResponseDto> rejectLeave(@RequestBody @PathVariable Long id){
        return ResponseEntity.ok(leaveService.rejectLeave(id));
    }

    @GetMapping(SEE_DETAIL)
    public ResponseEntity<LeaveDetailResponseDto> seeDetail(@PathVariable Long authid){
        return ResponseEntity.ok(leaveService.seeDetail(authid));
    }

}
