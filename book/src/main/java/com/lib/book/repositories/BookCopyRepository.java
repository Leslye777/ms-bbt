package com.lib.book.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.book.entities.BookCopy;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

	List<BookCopy> findByBookId(Long BookId);

}