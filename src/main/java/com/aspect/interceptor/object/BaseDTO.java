package com.aspect.interceptor.object;

import java.io.Serializable;


public class BaseDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1776264444315619092L;
	//response code
    protected int status;
    //code sendiri
    protected int code;
    //message
    protected String message;
    //trace id
    protected String traceID;

    public BaseDTO(){}

    public BaseDTO(int status, int code, String message, String traceID){
        this.status = status;
        this.code = code;
        this.message = message;
        this.traceID = traceID;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTraceID() {
		return traceID;
	}

	public void setTraceID(String traceID) {
		this.traceID = traceID;
	}
    
    
}
