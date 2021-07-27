package com.vehicles.project;

import java.util.*;
import java.util.Scanner;

import com.vehicles.project.exceptions.InvalidWheelDiameterException;
import com.vehicles.project.exceptions.MissingLicenseException;
import com.vehicles.project.people.Driver;
import com.vehicles.project.people.License;
import com.vehicles.project.people.VehicleHolder;
import com.vehicles.project.vehicles.Bike;
import com.vehicles.project.vehicles.Car;
import com.vehicles.project.vehicles.Truck;
import com.vehicles.project.vehicles.Wheel;

public class Main {

	static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("Dades per identificació: ");
		System.out.println("Escriu el teu nom: ");
		String nom = lector.nextLine();
		
		System.out.println("Excriu el primer cognom: ");
		String cognom = lector.nextLine();
		
		System.out.println("Any de naixement: ");
		int any = lector.nextInt();
		lector.nextLine();
		System.out.println("Mes del any de naixement: ");
		int mes = lector.nextInt();
		lector.nextLine();
		System.out.println("Día del mes:");
		int dia = lector.nextInt();
		lector.nextLine();
		GregorianCalendar dataNaixement = new GregorianCalendar(any, mes, dia);
		
		
		System.out.println("D´acord " + nom + ", necessitem les dades de la llicència. Escriu el ID: ");
		int idLlicencia = lector.nextInt();
		lector.nextLine();
		
		System.out.println("Tipus de llicència: A, B ó C");
		String tipusLlicencia = lector.nextLine().toUpperCase();
		
		System.out.println(tipusLlicencia);
		
		System.out.println("Nom complet llicència: ");
		String nomLlicencia = lector.nextLine();
		
		License llicencia = new License(idLlicencia, tipusLlicencia, nomLlicencia);
		
		System.out.println("Tens assegurança?");
		boolean hasSeguro;
		String resposta1 = lector.nextLine();
		hasSeguro = resposta1.toLowerCase().equals("si")? true : false;
		
		boolean hasGaratge;
		System.out.println("Tens garatge?");
		String resposta2 = lector.nextLine();
		hasGaratge = resposta2.toLowerCase().equals("si") ? true : false;
		
		VehicleHolder titular = new VehicleHolder(nom, cognom, dataNaixement, llicencia, hasSeguro, hasGaratge);
		
		System.out.println(titular.toString());
		
		System.out.println("¿Quin vehicle vols? \n1. Un cotxe\n2. Una moto\n3. Un camió");
		int eleccio = lector.nextInt();
		lector.nextLine();
		
		if(eleccio==1) {
			
			if(titular.getLicense().getType().equals("B")) {
				
				System.out.println("Escriu la matrícula del cotxe: ");
				String matriculaCotxe = lector.nextLine();
				
				System.out.println("Escriu la marca: ");
				String marcaCotxe = lector.nextLine();
				
				System.out.println("Especifica el color: ");
				String colorCotxe = lector.nextLine();
				
				Car car = new Car(matriculaCotxe, marcaCotxe, colorCotxe);
				
				System.out.println("Possar les rodes del davant!");
				Wheel rodaDavant = demanarRoda();
				
				System.out.println("Possar les rodes del darrere!");
				Wheel rodaDarrere = demanarRoda();
				
				List<Wheel> rodesDavant = new ArrayList<>();
				rodesDavant.add(rodaDavant);
				rodesDavant.add(rodaDavant);
				
				List<Wheel> rodesDarrere = new ArrayList<>();
				rodesDarrere.add(rodaDarrere);
				rodesDarrere.add(rodaDarrere);
				
				car.addWheels(rodesDavant, rodesDarrere);
				
				System.out.println(car.toString());
				
				if(isAlsoDriver()) {
					System.out.println("Gràcies!");
				}else {
					Driver driver = createDriverForLicense("B");
					System.out.println("Gràcies " + driver.getName() + ", les seves dades: ");
					System.out.println(driver.toString());
					System.out.println("Pot conduir el cotxe!");
				}
			}else {
				throw new MissingLicenseException();
			}
			
		}else if(eleccio==2) {
			
			if(titular.getLicense().getType().equals("A")) {
				
				System.out.println("Escriu la matrícula de la moto: ");
				String matriculaMoto = lector.nextLine();
				
				System.out.println("Escriu la marca: ");
				String marcaMoto = lector.nextLine();
				
				System.out.println("Específica el color: ");
				String colorMoto = lector.nextLine();
				
				Bike bike = new Bike(matriculaMoto, marcaMoto, colorMoto);
				
				System.out.println("Possar rodes davant!");
				Wheel rodaDavant = demanarRoda();
				
				System.out.println("Possar rodes darrere!");
				Wheel rodaDarrere = demanarRoda();
				
				bike.addWheels(rodaDavant, rodaDarrere);
				
				System.out.println(bike.toString());
				
				if(isAlsoDriver()) {
					System.out.println("Gràcies!");
				}else {
					Driver driver = createDriverForLicense("A");
					System.out.println("Gràcies " + driver.getName() + ", les seves dades: ");
					System.out.println(driver.toString());
					System.out.println("Pot conduir la moto!");
				}
				
			}else {
				throw new MissingLicenseException();
			}
			
		}else if(eleccio==3){
			
			if(titular.getLicense().getType().equals("C")) {
				
				System.out.println("Escriu la matrícula del camió: ");
				String matriculaCamio = lector.nextLine();
				
				System.out.println("Escriu la marca: ");
				String marcaCamio = lector.nextLine();
				
				System.out.println("Específica el color: ");
				String colorCamio = lector.nextLine();
				
				Truck truck = new Truck(matriculaCamio, marcaCamio, colorCamio);
				
				System.out.println("Quantes rodes té el camió: 4, 6, 8, 10 ó 12 ?");
				
				int rodesTotalsCamio = lector.nextInt();
				lector.nextLine();
				
				List<Wheel> rodesCamio = new ArrayList<>();
				
				System.out.println("Marca i diàmetre de les rodes ");
				
				for(int i=0;i<rodesTotalsCamio/2;i++) {
					
					System.out.println("Escriu el nombre de rodes " + (i+1));
					Wheel roda = demanarRoda();
					rodesCamio.add(roda);
					rodesCamio.add(roda);
				}
				
				truck.addWheels(rodesCamio);
				
				System.out.println("Nombre correcte de rodes: " + truck.suitableNumberOfWheels());
				
				System.out.println(truck.toString());
				
				if(isAlsoDriver()) {
					System.out.println("Gràcies!");
				}else {
					Driver driver = createDriverForLicense("C");
					System.out.println("Gracies " + driver.getName() + ", les seves dades: ");
					System.out.println(driver.toString());
					System.out.println("Pot conduir el camió!");
				}
			}else {
				
				throw new MissingLicenseException();
			}
			
		}else {
			System.err.println("Nomès hi ha tres opcions: [1 -> Coche | 2 -> Moto | 3 -> Camion]");
		}
		
		lector.close();
	}
	
	public static Wheel demanarRoda() throws InvalidWheelDiameterException {
		
		Wheel roda;
		
		System.out.println("Escriu la marca de la roda: ");
		String marcaRoda = lector.nextLine();
		
		System.out.println("Escriu el diàmetre: ");
		double diametreRoda = lector.nextDouble();
		lector.nextLine();
		
		roda = new Wheel(marcaRoda, diametreRoda);
		
		return roda;
	}
	
	public static boolean isAlsoDriver() {
		
		boolean isDriver;
		System.out.println("A més del titular del vehicle, ets el conductor? ");
		String rsp3 = lector.nextLine();
		
		isDriver = (rsp3.toLowerCase().equals("si")) ? true : false;
		
		return isDriver;
	}
	
	public static Driver createDriverForLicense(String typeOfLicense) throws Exception {
		
		System.out.println("Dades per la identificació: ");
		
                System.out.println("Escriu el teu nom: ");
		String nomConductor = lector.nextLine();
		
		System.out.println("Escriu el cognom: ");
		String cognomConductor = lector.nextLine();
		
		System.out.println("Any de neixement: ");
		int anyConductor = lector.nextInt();
		lector.nextLine();
                
		System.out.println("Mes de neixement: ");
		int mesConductor = lector.nextInt();
		lector.nextLine();
                
		System.out.println("Día del mes:");
		int diaConductor = lector.nextInt();
		lector.nextLine();
		GregorianCalendar dataConductor = new GregorianCalendar(anyConductor, mesConductor, diaConductor);
		
		
		System.out.println("D´acord " + nomConductor + ", llicència de conduir. Escriu el ID: ");
		int idLlicencia = lector.nextInt();
		lector.nextLine();
		
		System.out.println("Necesitas una llicència de tipus " + typeOfLicense + " per conduir aquest vehicle. Escriu el teu tipus de llicència: ");
		String tipusLlicencia = lector.nextLine().toUpperCase();
		
		while(!tipusLlicencia.toUpperCase().equals(typeOfLicense.toUpperCase())) {
			System.out.println("Llicència: " + tipusLlicencia + " no coincideix amb: " + typeOfLicense + "\nEscriu el tipus de llicència: ");
			tipusLlicencia = lector.nextLine();
		}
		
		System.out.println("Nombre complet llicència: ");
		String nomLlicencia = lector.nextLine();
		
		License llicenciaConductor = new License(idLlicencia, tipusLlicencia, nomLlicencia);
		
		Driver driver = new Driver(nomConductor, cognomConductor, dataConductor, llicenciaConductor);
		
		return driver;
	}
}

   



