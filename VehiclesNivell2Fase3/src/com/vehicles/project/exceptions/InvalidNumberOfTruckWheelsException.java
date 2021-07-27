package com.vehicles.project.exceptions;

public class InvalidNumberOfTruckWheelsException extends Exception {

	private static final String INVALID_NUMBER_WHEELS_ERROR = 
                "El camió ha de tenir entre quatre o dotze rodes";
	
	public InvalidNumberOfTruckWheelsException() {
		super(INVALID_NUMBER_WHEELS_ERROR);
	}
}