package com.cg.health_assisst.exception;

/**
 * creating INvalidIdException class to throw exception when the user gives
 * invalid Id
 *
 */
public class InvaliIdException extends Exception {
	/**
	 * creating InvalidException to return message from super class exception
	 * 
	 * @param message
	 */
	public InvaliIdException(String message) {
		super(message);
	}

}
