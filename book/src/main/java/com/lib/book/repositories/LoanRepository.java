package com.lib.book.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lib.book.entities.BookCopy;
import com.lib.book.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	List<Loan> findByBookCopyId(Long id);

}
