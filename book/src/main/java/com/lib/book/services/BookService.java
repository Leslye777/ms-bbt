package com.lib.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.book.entities.Book;
import com.lib.book.entities.BookCopy;
import com.lib.book.entities.Loan;
import com.lib.book.repositories.BookCopyRepository;
import com.lib.book.repositories.BookRepository;
import com.lib.book.repositories.LoanRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private BookCopyRepository bookCopyRepository;
    
    @Autowired
    private BookCopyService bookCopyService;
    
    @Autowired
    private LoanRepository loanRepository;
    
    
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    public List<Book> getAllBooks() {
    	
        return bookRepository.findAll();
    }
    
    public Book createBook(Book book) {
    	book = bookRepository.save(book); 
    	bookCopyService.createBookCopies(book.getId(), 1L);
    	return book;
        
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setDescription(book.getDescription());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublicationYear(book.getPublicationYear());
            existingBook.setPublisher(book.getPublisher());            
            
            return bookRepository.save(existingBook);
        }
        return null;
    }
    
    @Transactional
    public void deleteBook(Long bookId) {
        // Step 1: Find all book copies associated with the book to be deleted
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopiesByBookId(bookId);

        // Step 2: Find all loans associated with these book copies
        List<Loan> loans = new ArrayList<>();
        for (BookCopy bookCopy : bookCopies) {
            List<Loan> loansForCopy = loanRepository.findAllByBookCopyId(bookCopy.getId());
            loans.addAll(loansForCopy);
        }

        // Step 3: Delete all loans
        loanRepository.deleteAll(loans);

        // Step 4: Delete all book copies
        bookCopyRepository.deleteAll(bookCopies);

        // Step 5: Delete the book
        bookRepository.deleteById(bookId);
    }
    
    
    //adequadar aos principios do solid não esquecer
//    @Transactional
//    public void deleteBook(Long bookId) {
//        // Step 1: Find all book copies associated with the book to be deleted
//        List<BookCopy> bookCopies = bookCopyRepository.findByBookId(bookId);
//
//        // Step 2: Find all loans associated with these book copies
//        List<Loan> loans = new ArrayList<>();
//        for (BookCopy bookCopy : bookCopies) {
//            List<Loan> loansForCopy = loanRepository.findByBookCopyId(bookCopy.getId());
//            loans.addAll(loansForCopy);
//        }
//
//        // Step 3: Delete all loans
//        loanRepository.deleteAll(loans);
//
//        // Step 4: Delete all book copies
//        bookCopyRepository.deleteAll(bookCopies);
//
//        // Step 5: Delete the book
//        bookRepository.deleteById(bookId);
//    }
}