package com.nttdata.spring.services;

import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Floor;
import com.nttdata.spring.persistence.Occupant;

/**
 * Taller Spring - 1
 * 
 * Interfaz - Apartamento
 * 
 * @author Rafael José
 *
 */

@Service
public interface ApartmentManagementI {

	// Métodos para implementar
	public void createApartment(Apartment apartment, Character number);

	public void setFloor(Apartment apartment, Floor floor);

	public void addOccupant(Apartment apartment, Occupant occupant);
	
	public void addApartment(Apartment apartment);
}
