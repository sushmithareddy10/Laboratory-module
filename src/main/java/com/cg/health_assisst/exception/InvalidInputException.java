package com.cg.health_assisst.exception;

/**
 * creating class InvalidInputException to throw exception when user gives
 * invalid input
 *
 */
public class InvalidInputException extends Exception {
	/**
	 * creating InvalidInputException method to return message from super class
	 * Exception
	 * 
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
	}

}
