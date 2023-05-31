package com.hrworkforce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country 
{
	@Id
	private int countryId;
	
//	@Column(name="Name")
	private String countryName;	
	
//	@Column(name="Language")
	private String countryLanguage;

		
//	@Column(name="Capital")
	private String countryCapital;
	
	


}
