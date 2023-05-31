package com.hrworkforce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrworkforce.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>
{

}
