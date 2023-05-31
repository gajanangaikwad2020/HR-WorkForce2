package com.hrworkforce.service;

import java.util.List;

import com.hrworkforce.entity.Employee;

public interface EmployeeService 
{
	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	public Employee deleteEmployeeById(int empId);

	public List<Employee> getAllEmployees(); 

}
