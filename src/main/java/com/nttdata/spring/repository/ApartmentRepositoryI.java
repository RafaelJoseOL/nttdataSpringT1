package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.persistence.Apartment;

/**
 * Taller Spring - 1
 * 
 * Repositorio de Apartamento.
 * 
 * @author Rafael José
 *
 */

@Repository
public interface ApartmentRepositoryI extends JpaRepository<Apartment, Long> {

}
