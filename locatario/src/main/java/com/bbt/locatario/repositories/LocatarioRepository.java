package com.bbt.locatario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbt.locatario.entities.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Long>{

}
