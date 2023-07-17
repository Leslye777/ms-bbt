package com.lib.book.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lib.book.entities.Loan;
import com.lib.book.services.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanResource {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<?> borrowBook(@RequestParam Long userId, @RequestParam Long bookCopyId) {
        try {
            Loan loan = loanService.borrowBook(userId, bookCopyId);
            return ResponseEntity.ok(loan);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable("id") Long bookCopyId) {
        Loan loan = loanService.returnBook(bookCopyId);
        return ResponseEntity.ok(loan);
    }

    //mudar pro bookCopyId
    @PutMapping("/{id}/renew")
    public ResponseEntity<Loan> renewLoan(@PathVariable("id") Long loanId) {
        Loan loan = loanService.renewLoan(loanId);
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Loan>> getLoanById(@PathVariable("id") Long loanId) {
        Optional<Loan> loan = loanService.getLoanById(loanId);
        return ResponseEntity.ok(loan);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable("id") Long loanId) {
    	 List<Loan> loans = loanService.getAllLoansByUserId(loanId);
         return ResponseEntity.ok(loans);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.listLoans();
        return ResponseEntity.ok(loans);
    }
}
