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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Taller Spring - 1
 * 
 * Tabla Piso.
 * 
 * @author Rafael José
 *
 */

@Entity
@Table(name = "NTTDATA_T1_APARTMENT")
public class Apartment implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** ID del piso (PK) */
	private Long apartmentId;

	/** Letra del piso */
	private Character apartmentNumber;

	/** Planta a la que pertenece (FK) */
	private Floor floor;

	/** Lista de habitantes del piso (FK) */
	private List<Occupant> occupantsList = new ArrayList<>();

	/**
	 * @return apartmentId
	 */
	@Id
	@Column(name = "APARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_id_Sequence")
	@SequenceGenerator(name = "apartment_id_Sequence", sequenceName = "APARTMENT_ID_SEQ")
	public Long getApartmentId() {
		return apartmentId;
	}

	/**
	 * @param apartmentId to be set
	 */
	public void setApartmentId(Long apartmentId) {
		this.apartmentId = apartmentId;
	}

	/**
	 * @return apartmentNumber
	 */
	@Column(name = "APARTMENT_NUMBER")
	public Character getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * @param apartmentNumber to be set
	 */
	public void setApartmentNumber(Character apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * @return the floor
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLOOR_NUMBER")
	public Floor getFloor() {
		return floor;
	}

	/**
	 * @param floor to be set
	 */
	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	/**
	 * @return occupantsList
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "apartment")
	@Column(name = "OCCUPANTS_LIST")
	public List<Occupant> getOccupantsList() {
		return occupantsList;
	}

	/**
	 * @param occupantsList to be set
	 */
	public void setOccupantsList(List<Occupant> occupantsList) {
		this.occupantsList = occupantsList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Apartment: \nApartment ID: " + apartmentId + "\nApartment number: " + apartmentNumber + "\nFloor: "
				+ floor.getFloorNumber() + "\nHabitantes: ");
		for (int i = 0; i < occupantsList.size(); i++) {
			sb.append(", " + occupantsList.get(i).getOccupantName());
		}
		return sb.toString();
	}
}
