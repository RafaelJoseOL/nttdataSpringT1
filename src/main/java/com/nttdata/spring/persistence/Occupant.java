package com.nttdata.spring.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Taller Spring - 1
 * 
 * Tabla Inquilino.
 * 
 * @author Rafael José
 *
 */

@Entity
@Table(name = "NTTDATA_T1_OCCUPANT")
public class Occupant implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** ID del inquilino (PK) */
	private Long ocuppantId;

	/** Nombre del inquilino */
	private String ocuppantName;

	/** Apellidos del inquilino */
	private String ocuppantLastName;
	
	/** Piso del inquilino (FK) */
	private Apartment apartment;

	/**
	 * @return ocuppantId
	 */
	@Id
	@Column(name = "OCCUPANT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocuppant_id_Sequence")
	@SequenceGenerator(name = "ocuppant_id_Sequence", sequenceName = "OCCUPANT_ID_SEQ")
	public Long getOccupantId() {
		return ocuppantId;
	}

	/**
	 * @param ocuppantId to be set
	 */
	public void setOccupantId(Long ocuppantId) {
		this.ocuppantId = ocuppantId;
	}

	/**
	 * @return ocuppantName
	 */
	@Column(name = "OCCUPANT_NAME")
	public String getOccupantName() {
		return ocuppantName;
	}

	/**
	 * @param ocuppantName to be set
	 */
	public void setOccupantName(String ocuppantName) {
		this.ocuppantName = ocuppantName;
	}

	/**
	 * @return ocuppantLastName
	 */
	@Column(name = "OCCUPANT_LAST_NAME")
	public String getOccupantLastName() {
		return ocuppantLastName;
	}

	/**
	 * @param ocuppantLastName to be set
	 */
	public void setOccupantLastName(String ocuppantLastName) {
		this.ocuppantLastName = ocuppantLastName;
	}
	
	/**
	 * @return the apartment
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "APARTMENT_ID")
	public Apartment getApartment() {
		return apartment;
	}

	/**
	 * @param apartment to be set
	 */
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return "Occupant: \nOcuppant ID: " + ocuppantId + "\nOcuppant name: " + ocuppantName + "\nOcuppant last name: "
				+ ocuppantLastName + "\nApartment: " + apartment.getApartmentId();
	}
}
