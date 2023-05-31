package com.hrworkforce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hrworkforce.dao.EmployeeDao;
import com.hrworkforce.entity.Country;
import com.hrworkforce.entity.Employee;
import com.hrworkforce.service.EmployeeService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HrWorkForceApplicationTests 
{
	@Autowired
	private EmployeeService employoeeServiceImpl;
	
	@MockBean  //Dummy or mock object 
	private EmployeeDao employeeDao;
	
	@BeforeEach
	void setup()
	{
		Optional<Employee> dummyEmpObject = Optional.of(new Employee(2, "Vishal kale", "Nagar", 15000, "BA", new Country(9, "Austreliya", "Spanich", "Canbera")));
		when(employeeDao.findById(2)).thenReturn(dummyEmpObject);
		
//		Optional<Employee> dummyEmpObject2 = Optional.of(new Employee(5, "Sonu Pande", "Pune", 10000, "HR"));
//		Mockito.when(employeeDao.deleteById(5)).thenReturn(dummyEmpObject2);
//		
		
	}
	
	@Test
	@Order(1)
	public void testSaveEmployee()
	{
		Employee empTest=new Employee(1, "Ramesh Pande", "Pune", 10000, "ADMIN", null);
		when(employeeDao.save(empTest)).thenReturn(empTest);
		assertEquals(empTest, employoeeServiceImpl.saveEmployee(empTest));
	}
		
	@Test
	@Order(2)
	public void testgetEmployeeByid()
	{
		String empName="Vishal kale";
		Employee employeeInServ = employoeeServiceImpl.getEmployeeById(2);
		assertEquals(empName, employeeInServ.getEmpName());
		
//		Employee empTest=new Employee(2, "Vishal kale", "Nagar", 15000, "BA");
//		employeeDao.save(empTest);
	}
	
	@Test
	@Order(4)
	public void testDeleteEmployee()
	{
		Employee empTest=new Employee(5, "Sonu Pande", "Pune", 10000, "HR", null);
		Employee deleteEmployeeById = employoeeServiceImpl.deleteEmployeeById(empTest.getEmpId());
		when(employeeDao.findById(empTest.getEmpId())).thenReturn(Optional.of(empTest));
		
		assertEquals(deleteEmployeeById,employoeeServiceImpl.deleteEmployeeById(empTest.getEmpId()));
//		verify(employeeDao,times(1)).delete(empTest);
	}
	
	@Test
	@Order(3)
	public void testgetAllEmployee() 
	{
		Employee empTest1=new Employee(4, "Vishal Bobade", "Malegaon", 25000,"BA", null);  //new Country(9, "Austreliya", "Spanich", "Canbera")
		Employee empTest2=new Employee(5, "Sonu Pande", "Pune", 10000, "HR", null);
		List<Employee> list=Arrays.asList(empTest1,empTest2);
		
		when(employeeDao.findAll()).thenReturn(list);
		assertEquals(2,employoeeServiceImpl.getAllEmployees().size());
	}
//	@Test
//	@Order(2)
//	public void testUpdateEmployee() 
//	{
//		Employee empTest=new Employee(5, "Vishal Bobade", "Washim", 25000,"BA");
//		employeeDao.save(empTest);
//		assertNotNull(employeeDao.findById(5).get());
//	}

}
