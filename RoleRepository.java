package com.greatLearning.employeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.employeeManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
