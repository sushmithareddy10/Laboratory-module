package com.cg.health_assisst.exception;

/**
 * creating class NullObjectException to throw exception when null object is
 * created
 *
 */
public class NullObjectExcpetion extends Exception {
	/**
	 * creating NullObjectException method to return message from super class
	 * Exception
	 * 
	 * @param message
	 */
	public NullObjectExcpetion(String message) {
		super(message);
	}

}
