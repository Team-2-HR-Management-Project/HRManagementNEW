package com.team2.repository;


import com.team2.repository.entity.User;
import com.team2.repository.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {


    Optional<User> findOptionalByAuthid(Long authid);

    Optional<List<User>> findAllOptionalByRole(ERole role);
}
