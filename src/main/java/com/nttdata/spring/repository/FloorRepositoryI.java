package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.persistence.Floor;

/**
 * Taller Spring - 1
 * 
 * Repositorio de Piso.
 * 
 * @author Rafael José
 *
 */

@Repository
public interface FloorRepositoryI extends JpaRepository<Floor, Long> {

}
