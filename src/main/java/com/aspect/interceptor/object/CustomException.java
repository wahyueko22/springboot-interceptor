package com.aspect.interceptor.object;

import com.aspect.interceptor.constant.EnumerationMessage;

public class CustomException extends Exception {

    private Exception exception;
    private EnumerationMessage enumerationMessage;

    public CustomException(Exception exception, EnumerationMessage enumerationMessage) {
    	super(enumerationMessage.getMessage());
        this.exception = exception;
        this.enumerationMessage = enumerationMessage;
    }
    
    public CustomException(EnumerationMessage enumerationMessage) {
    	super(enumerationMessage.getMessage());
        this.enumerationMessage = enumerationMessage;
    }

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public EnumerationMessage getEnumerationMessage() {
		return enumerationMessage;
	}

	public void setEnumerationMessage(EnumerationMessage enumerationMessage) {
		this.enumerationMessage = enumerationMessage;
	}
    
    
}
