package com.emplyebank.project.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emplyebank.project.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}