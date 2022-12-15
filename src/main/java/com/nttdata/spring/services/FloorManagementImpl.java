package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Floor;
import com.nttdata.spring.repository.FloorRepositoryI;

/**
 * Taller Spring - 1
 * 
 * Implementacion de Planta
 * 
 * @author Rafael José
 *
 */

@Service("floor")
@Primary
public class FloorManagementImpl implements FloorManagementI {

	@Autowired
	FloorRepositoryI floorRepo;

	@Override
	public void setApartment(Floor floor, Apartment apartment) {
		List<Apartment> apartmentsList = floor.getApartmentsList();
		apartmentsList.add(apartment);
		floor.setApartmentsList(apartmentsList);
	}

	@Override
	public void addFloor(Floor floor) {
		floorRepo.save(floor);
	}
}
