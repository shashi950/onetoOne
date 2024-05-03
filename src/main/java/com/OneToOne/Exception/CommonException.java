package com.OneToOne.Exception;

public class CommonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public CommonException(String msg) {
	super(String.valueOf(msg));
}
}
