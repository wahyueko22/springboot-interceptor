package com.aspect.interceptor.object;


import java.util.List;

public class ValidationDTO extends BaseDTO {
    private List<ValidationMessage> data;

    public ValidationDTO() {};
    public ValidationDTO(int status, int code, String message, String traceID, List<ValidationMessage> data) {
        super(status, code, message, traceID);
        this.data = data;
    }
  
    public List<ValidationMessage> getData() {
		return data;
	}
    
	public void setData(List<ValidationMessage> data) {
		this.data = data;
	}
	
}
