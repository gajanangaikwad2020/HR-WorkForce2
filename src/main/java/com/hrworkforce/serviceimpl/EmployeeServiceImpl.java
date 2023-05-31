package com.hrworkforce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrworkforce.dao.EmployeeDao;
import com.hrworkforce.entity.Employee;
import com.hrworkforce.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public Employee saveEmployee(Employee employee) 
	{
		Employee emp1= employeeDao.save(employee);
		return emp1;
	}
	
	@Override
	public Employee updateEmployee(Employee employee) 
	{
		Employee dbEmployee = employeeDao.findById(employee.getEmpId()).get();
		if(dbEmployee!=null)
		{
			employeeDao.save(employee);
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int empId) 
	{
		Employee dbEmployee = employeeDao.findById(empId).get();
		return dbEmployee;
	}

	@Override
	public Employee deleteEmployeeById(int empId) 
	{
		Employee dbEmployee = employeeDao.findById(empId).get();
		if(dbEmployee!=null)
		{
			employeeDao.deleteById(empId);
		}
		return dbEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> empList = employeeDao.findAll();
		return empList;
	}

	
}
