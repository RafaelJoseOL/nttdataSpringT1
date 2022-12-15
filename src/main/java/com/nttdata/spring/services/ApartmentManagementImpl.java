package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Floor;
import com.nttdata.spring.persistence.Occupant;
import com.nttdata.spring.repository.ApartmentRepositoryI;

/**
 * Taller Spring - 1
 * 
 * Implementacion de Apartamento
 * 
 * @author Rafael José
 *
 */

@Service("apartment")
@Primary
public class ApartmentManagementImpl implements ApartmentManagementI {

	@Autowired
	ApartmentRepositoryI apartmentRepo;
	
	@Override
	public void createApartment(Apartment apartment, Character number) {
		apartment.setApartmentNumber(number);
	}
	
	@Override
	public void setFloor(Apartment apartment, Floor floor) {
		apartment.setFloor(floor);
	}

	@Override
	public void addOccupant(Apartment apartment, Occupant occupant) {
		List<Occupant> occupantsList = apartment.getOccupantsList();
		occupantsList.add(occupant);
		apartment.setOccupantsList(occupantsList);
	}

	@Override
	public void addApartment(Apartment apartment) {
		apartmentRepo.save(apartment);
	}
}
