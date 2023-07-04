package com.lib.book.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.book.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	List<Loan> findByBookCopyId(Long id);

	List<Loan> findAllByOrderByLoanDateAsc();

	List<Loan> findAllByOrderByLoanDateDesc();

	List<Loan> findAllByUserId(Long userId);

	List<Loan> findAllByUserIdOrderByLoanDateDesc(Long userId);


}
