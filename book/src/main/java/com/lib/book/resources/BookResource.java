package com.lib.book.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.book.entities.Book;
import com.lib.book.repositories.BookRepository;

@RestController
@RequestMapping(value = "/book")
public class BookResource {

	@Autowired
	private BookRepository repository;

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		List<Book> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		Book book = repository.findById(id).get();
		return ResponseEntity.ok(book);
	}
}
