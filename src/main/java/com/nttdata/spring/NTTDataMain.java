package com.nttdata.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.persistence.Apartment;
import com.nttdata.spring.persistence.Floor;
import com.nttdata.spring.persistence.Occupant;
import com.nttdata.spring.services.ApartmentManagementI;
import com.nttdata.spring.services.FloorManagementI;
import com.nttdata.spring.services.OccupantManagementI;

/**
 * Taller Spring - 1
 * 
 * Clase principal
 * 
 * @author Rafael José
 *
 */
@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {

	/** Servicio de apartamentos */
	@Autowired
	private ApartmentManagementI apartmentService;

	/** Servicio de plantas */
	@Autowired
	private FloorManagementI floorService;

	/** Servicio de inquilinos */
	@Autowired
	private OccupantManagementI occupantService;

	private static final Logger LOG = LoggerFactory.getLogger(NTTDataMain.class);

	/**
	 * 
	 * Metodo principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	/**
	 * Metodo para gestionar inserciones y búsquedas en la BBDD.
	 */
	public void run(String... args) throws Exception {
		
		// Constantes
		final String RAFAEL = "Rafael";

		// Creación de plantas
		Floor floor1 = new Floor();
		Floor floor2 = new Floor();
		Floor floor3 = new Floor();

		// Creación de apartamentos
		Apartment apartment1 = new Apartment();
		Apartment apartment2 = new Apartment();
		Apartment apartment3 = new Apartment();
		Apartment apartment4 = new Apartment();
		Apartment apartment5 = new Apartment();
		Apartment apartment6 = new Apartment();
		Apartment apartment7 = new Apartment();
		Apartment apartment8 = new Apartment();
		Apartment apartment9 = new Apartment();
		Apartment apartment10 = new Apartment();
		Apartment apartment11 = new Apartment();
		Apartment apartment12 = new Apartment();
		assignApartmentsAndFloor(floor1, apartment1, 'A');
		assignApartmentsAndFloor(floor1, apartment2, 'B');
		assignApartmentsAndFloor(floor1, apartment3, 'C');
		assignApartmentsAndFloor(floor1, apartment4, 'D');
		assignApartmentsAndFloor(floor2, apartment5, 'A');
		assignApartmentsAndFloor(floor2, apartment6, 'B');
		assignApartmentsAndFloor(floor2, apartment7, 'C');
		assignApartmentsAndFloor(floor2, apartment8, 'D');
		assignApartmentsAndFloor(floor3, apartment9, 'A');
		assignApartmentsAndFloor(floor3, apartment10, 'B');
		assignApartmentsAndFloor(floor3, apartment11, 'C');
		assignApartmentsAndFloor(floor3, apartment12, 'D');

		// Creación de inquilinos
		Occupant occupant1 = new Occupant();
		Occupant occupant2 = new Occupant();
		Occupant occupant3 = new Occupant();
		Occupant occupant4 = new Occupant();
		Occupant occupant5 = new Occupant();
		Occupant occupant6 = new Occupant();
		Occupant occupant7 = new Occupant();
		Occupant occupant8 = new Occupant();
		Occupant occupant9 = new Occupant();
		Occupant occupant10 = new Occupant();
		assignOccupantsAndApartment(apartment1, occupant1, RAFAEL, "Ossorio Lopez");
		assignOccupantsAndApartment(apartment2, occupant2, "Maria", "Casais Perez");
		assignOccupantsAndApartment(apartment3, occupant3, "Marta", "Dacal Asin");
		assignOccupantsAndApartment(apartment4, occupant4, "Juan", "Jurado Garcia");
		assignOccupantsAndApartment(apartment6, occupant5, "Alberto", "Sanchez Garza");
		assignOccupantsAndApartment(apartment7, occupant6, "Luna", "Urriaga Silva");
		assignOccupantsAndApartment(apartment8, occupant7, "Julio", "Garcia Papadopoulos");
		assignOccupantsAndApartment(apartment9, occupant8, "Antonio", "Lopez Rossi");
		assignOccupantsAndApartment(apartment9, occupant9, "Pedro", "Smith Diaz");
		assignOccupantsAndApartment(apartment10, occupant10, "Marta", "Lozano Martinez");
		
		// Inserción en BBDD.
		floorService.addFloor(floor1);
		floorService.addFloor(floor2);
		floorService.addFloor(floor3);
		apartmentService.addApartment(apartment1);
		apartmentService.addApartment(apartment2);
		apartmentService.addApartment(apartment3);
		apartmentService.addApartment(apartment4);
		apartmentService.addApartment(apartment5);
		apartmentService.addApartment(apartment6);
		apartmentService.addApartment(apartment7);
		apartmentService.addApartment(apartment8);
		apartmentService.addApartment(apartment9);
		apartmentService.addApartment(apartment10);
		apartmentService.addApartment(apartment11);
		apartmentService.addApartment(apartment12);
		occupantService.addOccupant(occupant1);
		occupantService.addOccupant(occupant2);
		occupantService.addOccupant(occupant3);
		occupantService.addOccupant(occupant4);
		occupantService.addOccupant(occupant5);
		occupantService.addOccupant(occupant6);
		occupantService.addOccupant(occupant7);
		occupantService.addOccupant(occupant8);
		occupantService.addOccupant(occupant9);
		occupantService.addOccupant(occupant10);

		// Búsquedas en la BBDD y asignación a las listas.
		List<Occupant> allOccupants = occupantService.findAll();
		List<Occupant> occupantsByNameROL = occupantService.findByOccupantNameAndOccupantLastName(RAFAEL,
				"Ossorio Lopez");
		List<Occupant> occupantsByNameROL2 = occupantService.findByOccupantNameAndOccupantLastName(RAFAEL,
				"Osorio Lopez");
		
		// Resultados de las búsquedas mediante logger.
		for (int i = 0; i < allOccupants.size(); i++) {
			LOG.info("Occupant {}: {} {}", i + 1, allOccupants.get(i).getOccupantName(),
					allOccupants.get(i).getOccupantLastName());
		}

		for (int i = 0; i < occupantsByNameROL.size(); i++) {
			LOG.info("Occupant named {} Ossorio Lopez, ID: {}", RAFAEL, occupantsByNameROL.get(i).getOccupantId());
		}
		
		// Búsqueda con resultado vacio, no mostrará nada
		for (int i = 0; i < occupantsByNameROL2.size(); i++) {
			LOG.info("Occupant named {} Osorio Lopez: {}", RAFAEL, occupantsByNameROL2.get(i).getOccupantId());
		}		
	}

	/**
	 * Metodo para asignar a cada piso su información, y luego asignarselo a la planta correspondiente.
	 * 
	 * @param floor
	 * @param apartment
	 * @param apartmentNumber
	 */
	private void assignApartmentsAndFloor(Floor floor, Apartment apartment, Character apartmentNumber) {
		apartmentService.createApartment(apartment, apartmentNumber);
		apartmentService.setFloor(apartment, floor);
		floorService.setApartment(floor, apartment);
	}

	/**
	 * Metodo para rellenar la información de los inquilinos y añadirlos a su piso.
	 * 
	 * @param apartment
	 * @param occupant
	 * @param name
	 * @param lastName
	 */
	private void assignOccupantsAndApartment(Apartment apartment, Occupant occupant, String name, String lastName) {
		occupantService.createOccupant(occupant, name, lastName);
		occupantService.setApartment(occupant, apartment);
		apartmentService.addOccupant(apartment, occupant);
	}
}