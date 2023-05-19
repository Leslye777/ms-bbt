package com.lib.book.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.book.entities.BookCopy;
import com.lib.book.entities.Loan;
import com.lib.book.entities.Users;
import com.lib.book.feignclients.UserFeignClient;
import com.lib.book.repositories.BookCopyRepository;
import com.lib.book.repositories.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private BookCopyRepository bookCopyRepository;
	

	@Autowired
	private UserFeignClient userFeignClient;

	public Loan borrowBook(Long userId, Long bookCopyId) {
	    // Verificar se o livro está disponível para empréstimo
		

		Users user = userFeignClient.findById(userId).getBody();
		System.out.println(user.getEmail());
		
	    BookCopy bookCopy = bookCopyRepository.findById(bookCopyId)
	            .orElseThrow(() -> new IllegalArgumentException("BookCopy not found"));
	    
	    if (bookCopy.isReserved()) {
	        throw new IllegalArgumentException("BookCopy is reserved");
	    }
	    
	    if (bookCopy.isBorrowed()) {
	        throw new IllegalArgumentException("BookCopy is borrowed");
	    }
	    
	    // Criar empréstimo
	    Loan loan = new Loan();
	    loan.setBookCopy(bookCopy);
	    loan.setLoanDate(LocalDate.now());
	    loan.setExpecteReturnDate(LocalDate.now().plusDays(7));
	    loan.setUserId(userId);
	    loan.setReturned(false);
	    
	    // Marcar exemplar como indisponível
	    bookCopy.setBorrowed(true);
	    bookCopyRepository.save(bookCopy);
	    
	    // Salvar empréstimo
	    return loanRepository.save(loan);
	}

	public Loan returnBook(Long loanId) {
	    // Verificar se o empréstimo existe
	    Loan loan = loanRepository.findById(loanId)
	            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
	    
	    // Verificar se o exemplar está indisponível
	    BookCopy bookCopy = loan.getBookCopy();
	    if (!bookCopy.isBorrowed()) {
	        throw new IllegalArgumentException("BookCopy already returned");
	    }
	    
	    // Marcar exemplar como disponível
	    bookCopy.setBorrowed(false);
	    bookCopy.setReserved(false);
	    bookCopyRepository.save(bookCopy);
	    
	    // Marcar empréstimo como devolvido
	    loan.setReturned(true);
	    loan.setReturnDate(LocalDate.now());
	    
	    // Salvar empréstimo
	    return loanRepository.save(loan);
	}

	public Loan renewLoan(Long loanId) {
	    // Verificar se o empréstimo existe
	    Loan loan = loanRepository.findById(loanId)
	            .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
	    
	    // Verificar se o exemplar está indisponível
	    BookCopy bookCopy = loan.getBookCopy();
	    if (bookCopy.isReserved()) {
	        throw new IllegalArgumentException("BookCopy is reserved");
	    }
	    
	    if (!bookCopy.isBorrowed()) {
	        throw new IllegalArgumentException("BookCopy is not borrowed");
	    }
	    
	    // Renovar empréstimo
	    loan.setLoanDate(LocalDate.now());
	    loan.setExpecteReturnDate(LocalDate.now().plusDays(7));
	    
	    // Salvar empréstimo
	    return loanRepository.save(loan);
	}

	public List<Loan> listLoans() {
	    // Listar empréstimos
	    return loanRepository.findAll();
	}

	public Optional<Loan> getLoanById(Long loanId) {
		return loanRepository.findById(loanId);
	}

 

}
