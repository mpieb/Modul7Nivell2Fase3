package com.vehicles.project.exceptions;

public class InvalidBikeWheelsException extends Exception {
	
	private static final String INVALID_BIKE_WHEELS_EXCEPTION = 
                "El diàmetre de les rodes del darrere ha de coincidir amb les del davant";
	
	public InvalidBikeWheelsException() {
		super(INVALID_BIKE_WHEELS_EXCEPTION);
	}

}
