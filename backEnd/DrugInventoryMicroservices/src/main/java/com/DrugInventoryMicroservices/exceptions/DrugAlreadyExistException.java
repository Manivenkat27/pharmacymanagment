package com.DrugInventoryMicroservices.exceptions;

public class DrugAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DrugAlreadyExistException(String s) {
		super(s);
	}
	
	

}
