package com.vehicles.project.vehicles;

import java.util.List;

import com.vehicles.project.exceptions.InvalidNumberOfTruckWheelsException;
import com.vehicles.project.exceptions.InvalidPlateException;

public class Truck extends Vehicle{

	public Truck(String plate, String brand, String color) throws InvalidPlateException {
		super(plate, brand, color);
		
	}
	public void addWheels(List<Wheel> truckWheels) throws Exception {
		
		if (truckWheels.size()<4 || truckWheels.size()>12)
			throw new InvalidNumberOfTruckWheelsException();
		
		for(Wheel wh: truckWheels) this.wheels.add(wh);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		
		if (wheels.size() != 2)
			throw new Exception("Les rodes han de tenir nombre parell!");

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception("Les rodes de la esquerra no coincideixen amb les de la dreta!");

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
	@Override
	public boolean suitableNumberOfWheels() {
		
		boolean corrrectNumber = false;
		
		if (wheels.size()==4 || wheels.size()== 6 ||wheels.size()== 8 ||wheels.size()== 10 ||wheels.size()== 12)  corrrectNumber = true;
		
		return corrrectNumber;
	}

}
