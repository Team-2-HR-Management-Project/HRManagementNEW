package com.team2.controller;
import com.team2.dto.request.CreateExpenseRequestDto;
import com.team2.dto.response.ExpenseResponseDto;
import com.team2.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.team2.constants.ApiUrls.*;



@RestController
@RequiredArgsConstructor
@RequestMapping(EXPENSES)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExpenseController {

    private  final ExpenseService expenseService;

    @PostMapping(CREATE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody CreateExpenseRequestDto dto){
        return ResponseEntity.ok(expenseService.createExpense(dto));
    }

    @GetMapping(SEE_DETAIL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ExpenseResponseDto> seeDetail(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.seeDetail(id));
    }

    @GetMapping(FINDMYEXPENSES)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<ExpenseResponseDto>> getMyExpenses(@PathVariable Long authid){
        return ResponseEntity.ok(expenseService.getMyExpenses(authid));
    }
}
