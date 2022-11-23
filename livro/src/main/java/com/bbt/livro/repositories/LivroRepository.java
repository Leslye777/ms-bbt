package com.bbt.livro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbt.livro.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
