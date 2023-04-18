package com.lib.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.book.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
