package com.undefitable.TrainingInstitute.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.undefitable.TrainingInstitute.Entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
   
}