package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.persistence.Occupant;

/**
 * Taller Spring - 1
 * 
 * Repositorio de Habitante.
 * 
 * @author Rafael José
 *
 */

@Repository
public interface OccupantRepositoryI extends JpaRepository<Occupant, Long> {

	/**
	 * Búsqueda de inquilinos por nombre completo.
	 * 
	 * @param occupantName
	 * @param occupantLastName
	 * @return List<Occupant>
	 */
	public List<Occupant> findByOccupantNameAndOccupantLastName(final String occupantName,
			final String occupantLastName);
}
