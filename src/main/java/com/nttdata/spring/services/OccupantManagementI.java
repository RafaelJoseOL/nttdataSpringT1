package com.nttdata.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Occupant;

/**
 * Taller Spring - 1
 * 
 * Interfaz - Inquilino
 * 
 * @author Rafael José
 *
 */

@Service
public interface OccupantManagementI {

	// Métodos para implementar
	public void createOccupant(Occupant occupant, String occupantName, String occupantLastName);

	public void setApartment(Occupant occupant, Apartment apartment);
	
	public void addOccupant(Occupant occupant);

	public List<Occupant> findByOccupantNameAndOccupantLastName(final String occupantName,
			final String occupantLastName);
	
	public List<Occupant> findAll();
}
