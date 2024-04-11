package com.emplyebank.project.service;

import java.util.List;

import com.emplyebank.project.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto  updateEmplopyee);
	
	void deleteEmployee(Long employeeId);

}
