package com.nttdata.spring.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Taller Spring - 1
 * 
 * Tabla Planta.
 * 
 * @author Rafael José
 *
 */

@Entity
@Table(name = "NTTDATA_T1_FLOOR")
public class Floor implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Número de la planta (PK) */
	private Long floorNumber;

	/** Lista de pisos de la planta (FK) */
	private List<Apartment> apartmentsList = new ArrayList<>();

	/**
	 * @return floorNumber
	 */
	@Id
	@Column(name = "FLOOR_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "floor_number_Sequence")
	@SequenceGenerator(name = "floor_number_Sequence", sequenceName = "FLOOR_NUMBER_SEQ")
	public Long getFloorNumber() {
		return floorNumber;
	}

	/**
	 * @param floorNumber to be set
	 */
	public void setFloorNumber(Long floorNumber) {
		this.floorNumber = floorNumber;
	}

	/**
	 * @return apartmentsList
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "floor")
	@Column(name = "APARTMENTS_LIST")
	public List<Apartment> getApartmentsList() {
		return apartmentsList;
	}

	/**
	 * @param apartmentsList to be set
	 */
	public void setApartmentsList(List<Apartment> apartmentsList) {
		this.apartmentsList = apartmentsList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Floor: \nfloorNumber: " + floorNumber + "\nApartments list: ");
		for (int i = 0; i < apartmentsList.size(); i++) {
			sb.append(", " + apartmentsList.get(i).getApartmentId() + apartmentsList.get(i).getApartmentNumber());
		}
		return sb.toString();
	}
}
