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
    public ResponseEntity<Loan> borrowBook(@RequestParam Long userId, @RequestParam Long bookCopyId) {
        Loan loan = loanService.borrowBook(userId, bookCopyId);
        return ResponseEntity.ok(loan);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable("id") Long loanId) {
        Loan loan = loanService.returnBook(loanId);
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

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.listLoans();
        return ResponseEntity.ok(loans);
    }
}
