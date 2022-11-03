package com.itlogiclab.order.exception;

public class EvaluationFileHandlingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public EvaluationFileHandlingException(String message) {
		super(message);
		this.message=message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
