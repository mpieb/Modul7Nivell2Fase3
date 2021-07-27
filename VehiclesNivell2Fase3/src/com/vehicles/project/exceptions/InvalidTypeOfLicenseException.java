package com.vehicles.project.exceptions;

public class InvalidTypeOfLicenseException extends Exception{
	
	private static final String INVALID_TYPE_OF_LICENSE_ERROR = 
                "Nomès hi ha tres tipus de llicència: A, B o C ";
	
	public InvalidTypeOfLicenseException() {
		super(INVALID_TYPE_OF_LICENSE_ERROR);
	}

}

    