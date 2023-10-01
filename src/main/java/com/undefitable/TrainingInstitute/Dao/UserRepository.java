package com.undefitable.TrainingInstitute.Dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.undefitable.TrainingInstitute.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>  findByUsername(String username);
}

