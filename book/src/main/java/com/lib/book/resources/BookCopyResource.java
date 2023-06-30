package com.lib.book.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lib.book.DTO.CreateBookCopyRequestDTO;
import com.lib.book.entities.Book;
import com.lib.book.entities.BookCopy;
import com.lib.book.services.BookCopyService;

@RestController
@RequestMapping("/api/book-copies")

public class BookCopyResource {
    
    @Autowired
    private BookCopyService bookCopyService;
    
    @GetMapping("/{id}")
    public ResponseEntity<BookCopy> getBookCopy(@PathVariable Long id) {
        BookCopy bookCopy = bookCopyService.getBookCopy(id);
        if (bookCopy != null) {
            return ResponseEntity.ok(bookCopy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public List<BookCopy> getAllBookCopies() {
        return bookCopyService.getAllBookCopies();
    }
    
    
    @GetMapping("/book-id/{id}")
    public List<BookCopy> getAllBookCopiesByBookId(@PathVariable Long id) {
        return bookCopyService.getAllBookCopiesByBookId(id);
    }
    
    //create a TO to do that request body
    @PostMapping
    public ResponseEntity<List<BookCopy>> createBookCopy(@RequestBody CreateBookCopyRequestDTO requestDTO) {
        List<BookCopy> bookCopies = bookCopyService.createBookCopies(requestDTO.getBookId(), requestDTO.getNumberOfCopies());
        return ResponseEntity.ok(bookCopies);
    }


    
//    @PutMapping("/{id}")
//    public ResponseEntity<BookCopy> updateBookCopy(@PathVariable Long id, @RequestBody BookCopy bookCopy) {
//        BookCopy updatedBookCopy = bookCopyService.updateBookCopy(id, bookCopy);
//        if (updatedBookCopy != null) {
//            return ResponseEntity.ok(updatedBookCopy);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCopy(@PathVariable Long id) {
        boolean deleted = bookCopyService.deleteBookCopy(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
