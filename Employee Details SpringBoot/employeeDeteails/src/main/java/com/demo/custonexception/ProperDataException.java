package com.demo.custonexception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ProperDataException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus errorCode;
	private String errorMsg;
	
	
	

	public ProperDataException() {
		
	}

	public ProperDataException(HttpStatus errorCode, String errorMsg) {
		
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	

}
