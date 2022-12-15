package com.nttdata.spring.services;

import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Floor;

/**
 * Taller Spring - 1
 * 
 * Interfaz - Planta
 * 
 * @author Rafael José
 *
 */

@Service
public interface FloorManagementI {

	// Métodos para implementar
	public void setApartment(Floor floor, Apartment apartment);
	
	public void addFloor(Floor floor);
}
