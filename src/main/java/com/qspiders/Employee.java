package com.qspiders;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_management_system")
public class Employee {
	
	@Id
	private int employee_id;
	private String employee_name;
	private String employee_department;
	private double employee_salary;
	private LocalDate employee_joining_date;
	
	public Employee() {
	}
	
	public Employee(int employee_id, String employee_name, String employee_department, double employee_salary,
			LocalDate employee_joining_date) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_department = employee_department;
		this.employee_salary = employee_salary;
		this.employee_joining_date = employee_joining_date;
	}
	
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_department() {
		return employee_department;
	}
	public void setEmployee_department(String employee_department) {
		this.employee_department = employee_department;
	}
	public double getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(long employee_salary) {
		this.employee_salary = employee_salary;
	}



	public LocalDate getEmployee_joining_date() {
		return employee_joining_date;
	}



	public void setEmployee_joining_date(LocalDate employee_joining_date) {
		this.employee_joining_date = employee_joining_date;
	}




	
	

}
