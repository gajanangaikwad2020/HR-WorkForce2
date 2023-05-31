package com.hrworkforce.exception;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponce
{
	private Date timeStamp;
	private String fieldName;
	private String fieldMessage;
	private String status;
	
	

	
	
	
}