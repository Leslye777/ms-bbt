package com.lib.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.book.entities.Book;
import com.lib.book.entities.BookCopy;
import com.lib.book.repositories.BookCopyRepository;
import com.lib.book.repositories.BookRepository;

@Service
public class BookCopyService {
    
    @Autowired
    private BookCopyRepository bookCopyRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    public BookCopy getBookCopy(Long id) {
        return bookCopyRepository.findById(id).orElse(null);
    }
    
    public List<BookCopy> getAllBookCopies() {
        return bookCopyRepository.findAll();
    }
    
    public List<BookCopy> getAllBookCopiesByBookId(Long bookId) {
        return bookCopyRepository.findByBookId(bookId);
    }
    
    @Transactional
    public List<BookCopy> createBookCopies(Long bookId, Long numCopies) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            List<BookCopy> bookCopies = new ArrayList<>();
            for (int i = 0; i < numCopies; i++) {
                BookCopy bookCopy = new BookCopy();
                bookCopy.setBook(book);
                bookCopy.setReserved(false);
                bookCopy.setBorrowed(false);
                book.getCopies().add(bookCopy);
                bookCopies.add(bookCopyRepository.save(bookCopy));
            }
            bookRepository.save(book);
            return bookCopies;
        } else {
            throw new EntityNotFoundException("Book not found");
        }
    }

 
//    public BookCopy updateBookCopy(Long id, BookCopy bookCopy) {
//        Optional<BookCopy> optionalBookCopy = bookCopyRepository.findById(id);
//        if (optionalBookCopy.isPresent()) {
//            BookCopy existingBookCopy = optionalBookCopy.get();
//            existingBookCopy.setBook(bookCopy.getBook());
//            existingBookCopy.setAvailable(bookCopy.isAvailable());
//            return bookCopyRepository.save(existingBookCopy);
//        } else {
//            return null;
//        }
//    }
    
    public boolean deleteBookCopy(Long id) {
        Optional<BookCopy> optionalBookCopy = bookCopyRepository.findById(id);
        if (optionalBookCopy.isPresent()) {
            bookCopyRepository.delete(optionalBookCopy.get());
            return true;
        } else {
            return false;
        }
    }
}
