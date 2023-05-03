package com.lib.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.book.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
