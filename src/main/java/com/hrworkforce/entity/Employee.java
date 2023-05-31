package com.hrworkforce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Min(1)
	private int empId;
	
	@Column(unique = true)
	@NotNull(message = "Emp Name is Required")
	private String empName;	
	
	@Column(unique = true)
	@NotNull(message = "Emp Address is Required")
	private String empAddress;

	@Min(1)
	private double salary;
	
	@Column(unique = true)
	@NotNull(message = "Emp Dept is Required")	
	private String empDept;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Country country;
	
}
