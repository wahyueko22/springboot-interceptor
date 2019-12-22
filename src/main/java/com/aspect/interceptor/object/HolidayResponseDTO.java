package com.aspect.interceptor.object;

import java.io.Serializable;
import java.util.List;


public class HolidayResponseDTO extends BaseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5520586826036635362L;
	private List<DetailHolidayResponseDTO> data;
	public List<DetailHolidayResponseDTO> getData() {
		return data;
	}
	public void setData(List<DetailHolidayResponseDTO> data) {
		this.data = data;
	}
	
	
}
