package com.emplyebank.project.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emplyebank.project.dto.EmployeeDto;
import com.emplyebank.project.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/empl")
@AllArgsConstructor
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	//add emplpoyee
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedDto=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
	}
	
	
	//get empl
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	
	//find all
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employeeDtos= employeeService.getAllEmployee();
		return ResponseEntity.ok(employeeDtos);
	}
	
	//update empl
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updateEmPLOYEE){
		
	      EmployeeDto employeeDto= employeeService.updateEmployee(employeeId, updateEmPLOYEE);
	      return ResponseEntity.ok(employeeDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleEmployee(@PathVariable ("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("deleted succes");
	}
	
	
	
	
	
	
}
