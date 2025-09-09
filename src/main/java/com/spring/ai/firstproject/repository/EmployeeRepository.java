package com.spring.ai.firstproject.repository;

import com.spring.ai.firstproject.model.employee.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    EmployeeModel findAllByUsername(String userName);
}
