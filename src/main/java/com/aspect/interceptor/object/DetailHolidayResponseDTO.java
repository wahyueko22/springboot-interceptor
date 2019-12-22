package com.aspect.interceptor.object;

import java.io.Serializable;
import java.util.Date;

public class DetailHolidayResponseDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2462840702365597501L;
	//format yyyyMMdd
	private String date;
	private String type;
	private String description;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
