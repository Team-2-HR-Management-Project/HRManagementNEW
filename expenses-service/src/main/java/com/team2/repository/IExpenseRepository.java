package com.team2.repository;

import com.team2.repository.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense,Long> {
    Optional<List<Expense>> findAllOptionalByAuthid(Long authid);
}
