package com.vehicles.project.exceptions;

public class MissingLicenseException extends Exception{
	
	private static final String MISSING_LICENSE_ERROR = 
                "La llicència no és apte";
	
	public MissingLicenseException() {
		super(MISSING_LICENSE_ERROR);
	}

}

    