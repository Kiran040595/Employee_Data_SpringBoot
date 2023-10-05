package com.demo.custonexception;

import org.springframework.http.HttpStatus;

public class InvalidPageNumberException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private HttpStatus errorCode;
	private String errorMsg;
	public InvalidPageNumberException(HttpStatus errorCode, String errorMsg) {
		super();
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
