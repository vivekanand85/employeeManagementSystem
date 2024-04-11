package com.emplyebank.project.mapper;

import com.emplyebank.project.dto.EmployeeDto;
import com.emplyebank.project.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto maptoEmployeeDto(Employee employee) {
		return new EmployeeDto(
		employee.getId(),
		employee.getFristName(),
		employee.getLastName(),
		employee.getEmail()
		);
	}
	public static Employee maptoEmployee(EmployeeDto employeeDto) {
		return new Employee(
		employeeDto.getId(),
		employeeDto.getFristName(),
		employeeDto.getLastName(),
		employeeDto.getEmail()
		);
	}
}
