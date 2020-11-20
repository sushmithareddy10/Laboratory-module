package com.cg.health_assisst.exception;

/**
 * creating EmptyListException for throw throwing exception is list is empty
 *
 */
public class EmptyListException extends Exception {
	/**
	 * creating EmptyListException to return the message form super class Exception
	 * 
	 * @param message
	 */
	public EmptyListException(String message) {
		super(message);
	}

}
