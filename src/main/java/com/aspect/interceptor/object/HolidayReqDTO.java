package com.aspect.interceptor.object;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

public class HolidayReqDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8363440013644685265L;
	//@Max(value = 8, message = "{field.value.max}")
	@NotEmpty(message = "Please provide a name")
	private String employeeId;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date endDate;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
