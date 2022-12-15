package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Occupant;
import com.nttdata.spring.repository.OccupantRepositoryI;

/**
 * Taller Spring - 1
 * 
 * Implementacion de Inquilino
 * 
 * @author Rafael José
 *
 */

@Service("occupant")
@Primary
public class OccupantManagementImpl implements OccupantManagementI {

	@Autowired
	OccupantRepositoryI occupantRepo;
	
	@Override
	public void createOccupant(Occupant occupant, String occupantName, String occupantLastName) {
		occupant.setOccupantName(occupantName);
		occupant.setOccupantLastName(occupantLastName);
	}

	@Override
	public void setApartment(Occupant occupant, Apartment apartment) {
		occupant.setApartment(apartment);		
	}
	
	@Override
	public void addOccupant(Occupant occupant) {
		occupantRepo.save(occupant);
	}

	@Override
	public List<Occupant> findByOccupantNameAndOccupantLastName(String occupantName, String occupantLastName) {
		return occupantRepo.findByOccupantNameAndOccupantLastName(occupantName, occupantLastName);
	}

	@Override
	public List<Occupant> findAll() {
		return occupantRepo.findAll();
	}
}
