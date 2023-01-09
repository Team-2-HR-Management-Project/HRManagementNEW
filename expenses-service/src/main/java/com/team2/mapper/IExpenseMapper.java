package com.team2.mapper;



import com.team2.dto.request.CreateExpenseRequestDto;
import com.team2.dto.response.ExpenseResponseDto;
import com.team2.repository.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IExpenseMapper {

    IExpenseMapper INSTANCE = Mappers.getMapper(IExpenseMapper.class);

    Expense toExpense(final CreateExpenseRequestDto dto);
    ExpenseResponseDto toExpenseResponseDto(final Expense expense);
    List<ExpenseResponseDto> toExpenseResponseDtos(final List<Expense> expenses);
}
