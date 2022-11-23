package com.bbt.livro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbt.livro.entities.Livro;
import com.bbt.livro.repositories.LivroRepository;


@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroRepository repository;
	
	 
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id){
		Livro livro = repository.findById(id).get();
		return ResponseEntity.ok(livro);
	}
}
