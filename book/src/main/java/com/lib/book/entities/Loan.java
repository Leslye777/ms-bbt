package com.lib.book.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_copy_id")
    private BookCopy bookCopy;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "expected_return_date")
    private LocalDate expecteReturnDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "returned")
    private Boolean  returned;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
		return userId;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getExpecteReturnDate() {
		return expecteReturnDate;
	}

	public void setExpecteReturnDate(LocalDate expecteReturnDate) {
		this.expecteReturnDate = expecteReturnDate;
	}

	public Boolean isReturned() {
		return returned;
	}

	public void setReturned(Boolean returned) {
		this.returned = returned;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
