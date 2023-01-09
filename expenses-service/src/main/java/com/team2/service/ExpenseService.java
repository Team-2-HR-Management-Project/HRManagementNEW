package com.team2.service;

import com.team2.dto.request.CreateExpenseRequestDto;
import com.team2.dto.response.DetailResponseDto;
import com.team2.dto.response.ExpenseResponseDto;
import com.team2.exception.ErrorType;
import com.team2.exception.ExpenseManagerException;
import com.team2.manager.IUserManager;
import com.team2.mapper.IExpenseMapper;
import com.team2.repository.IExpenseRepository;
import com.team2.repository.entity.Expense;
import com.team2.utility.JwtTokenManager;
import com.team2.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService extends ServiceManager<Expense, Long> {
    private  final IExpenseRepository expenseRepository;
    private final JwtTokenManager jwtTokenManager;
    private  final IUserManager userManager;

    public ExpenseService(IExpenseRepository expenseRepository, JwtTokenManager jwtTokenManager, IUserManager userManager) {
        super(expenseRepository);
        this.expenseRepository = expenseRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.userManager = userManager;
    }

    public ExpenseResponseDto createExpense(CreateExpenseRequestDto dto) {
        try{
            Expense expense = IExpenseMapper.INSTANCE.toExpense(dto);
            expense.setCreateDate(System.currentTimeMillis());
            save(expense);
            return IExpenseMapper.INSTANCE.toExpenseResponseDto(expense);
        }catch (Exception e){
            throw new ExpenseManagerException(ErrorType.EXPENSE_NOT_CREATED);
        }
    }

    public ExpenseResponseDto seeDetail(Long id) {
        Optional<Expense> expense=findById(id);
        if(expense.isPresent()){
            ExpenseResponseDto dto = IExpenseMapper.INSTANCE.toExpenseResponseDto(expense.get());
            DetailResponseDto detailDto=userManager.findById(expense.get().getEmployeeid()).getBody();
            dto.setName(detailDto.getName());
            dto.setSurname(detailDto.getSurname());
            dto.setPhoto(detailDto.getPhoto());
            dto.setProfession(detailDto.getProfession());
            dto.setDepartment(detailDto.getDepartment());
            dto.setIdentityNumber(detailDto.getIdentityNumber());
            return dto;
        }else{
            throw new ExpenseManagerException((ErrorType.EXPENSE_NOT_FOUND));
        }
    }

    public List<ExpenseResponseDto> getMyExpenses(Long authid) {
        Optional<List<Expense>> leaves=expenseRepository.findAllOptionalByAuthid(authid);
        if(leaves.isPresent()){
            List<ExpenseResponseDto> leaveResponseDtos=IExpenseMapper.INSTANCE.toExpenseResponseDtos(leaves.get());

            return leaveResponseDtos.stream().map(x-> {
                DetailResponseDto detailDto=userManager.findById(x.getEmployeeid()).getBody();
                x.setName(detailDto.getName());
                x.setSurname(detailDto.getSurname());
                x.setPhoto(detailDto.getPhoto());
                x.setRole(detailDto.getRole());
                x.setDepartment(detailDto.getDepartment());
                x.setProfession(detailDto.getProfession());
                return x;

            }).collect(Collectors.toList());

        }else{
            throw new ExpenseManagerException((ErrorType.EXPENSE_NOT_FOUND));
        }
    }
}
