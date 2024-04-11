package com.emplyebank.project.dto;

public class EmployeeDto {

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(long id, String fristName, String lastName, String email) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
	}
	private long id;
	private String fristName;
	private String lastName;
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

