package com.bbt.locatario.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbt.locatario.entities.Locatario;
import com.bbt.locatario.repositories.LocatarioRepository;

@RestController
@RequestMapping(value = "/locatarios")
public class LocatarioResource {

	@Autowired
	private LocatarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Locatario>> findAll() {
		List<Locatario> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Locatario> findById(@PathVariable Long id) {
		Locatario locatario = repository.findById(id).get();
		return ResponseEntity.ok(locatario);
	}
}
