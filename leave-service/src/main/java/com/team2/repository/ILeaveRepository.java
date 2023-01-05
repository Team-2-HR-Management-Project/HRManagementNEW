package com.team2.repository;


import com.team2.repository.entity.Leave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ILeaveRepository extends JpaRepository<Leave,Long> {


    Optional<List<Leave>> findAllOptionalByManagerid(Long managerid);

    Optional<List<Leave>> findAllOptionalByAuthid(Long authid);
    Optional<Leave> findOptionalByAuthid(Long authid);
}
