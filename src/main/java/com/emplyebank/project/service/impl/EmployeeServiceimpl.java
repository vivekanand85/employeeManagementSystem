package com.emplyebank.project.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.emplyebank.project.dto.EmployeeDto;
import com.emplyebank.project.entity.Employee;
import com.emplyebank.project.entity.repository.EmployeeRepository;
import com.emplyebank.project.exception.ResourceNotFoundException;
import com.emplyebank.project.mapper.EmployeeMapper;
import com.emplyebank.project.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);		
		return EmployeeMapper.maptoEmployeeDto(savedEmployee);
	}

	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
	 Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("eMPLOYEE is not exist "+employeeId));
		
		return EmployeeMapper.maptoEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
	List<Employee> employees=employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.maptoEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmplopyee) {
		Employee Upaemployee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists wit give id"+employeeId));
		Upaemployee.setFristName(updateEmplopyee.getFristName());
		Upaemployee.setLastName(updateEmplopyee.getLastName());
		Upaemployee.setEmail(updateEmplopyee.getEmail());
		return EmployeeMapper.maptoEmployeeDto(Upaemployee);
	}
 
	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("employee not foiund wiht id"));
		employeeRepository.deleteById(employeeId);
	}

}
