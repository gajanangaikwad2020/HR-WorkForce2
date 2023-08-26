package com.hrworkforce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrworkforce.entity.Employee;
import com.hrworkforce.exception.ResourceAlreadyExistException;
import com.hrworkforce.exception.ResourceNotFoundException;
import com.hrworkforce.service.EmployeeService;
@RestController
@RequestMapping(value="/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/save-emp")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee employee)
	{
		Employee dbEmployee= employeeService.saveEmployee(employee);
		if(dbEmployee!=null)
		{
			return new ResponseEntity<String>("New Employee is Saved.",HttpStatus.CREATED);
		}
		else
		{
			throw new RuntimeException("Method Arguments are not valid.. Plz Give  proper input to the fields.");
		}
	}
	
	@PutMapping(value="/update-emp")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)
	{
		Employee dbEmployee= employeeService.updateEmployee(employee);
		if(dbEmployee!=null)
		{
			return new ResponseEntity<String>("Employee is Updated with employee Id ->."+employee.getEmpId(),HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Employee is not found for update with employee Id ->"+employee.getEmpId());
		}
	}
	
	@GetMapping(value="/get-emp-by-id/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId)
	{
		Employee dbEmployee= employeeService.getEmployeeById(empId);
		if(dbEmployee!=null)
		{
			return new ResponseEntity<Employee>(dbEmployee,HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Employee is not found for update with employee Id ->"+empId);
		}
	}
	
	@DeleteMapping(value="/delete-emp-by-id/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId)
	{
		Employee dbEmployee= employeeService.deleteEmployeeById(empId);
		if(dbEmployee!=null)
		{
			return new ResponseEntity<String>("Employee is Deleted with employee Id ->"+empId,HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Employee is not found for Delete with employee Id ->"+empId);
		}
	}
	
	@GetMapping(value="/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		 List<Employee> empList = employeeService.getAllEmployees();
		if(!empList.isEmpty())
		{
			System.out.println("New Added Line..");
			return new ResponseEntity<List<Employee>>(empList,HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Employee List Not Found.");
		}
	}
	


}
