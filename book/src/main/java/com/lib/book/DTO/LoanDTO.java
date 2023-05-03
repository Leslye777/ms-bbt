package com.lib.book.DTO;

import java.time.LocalDate;

public class LoanDTO {
    private Long id;
    private Long userId;
    private String userName;
    private Long bookCopyId;
    private String bookTitle;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate expecteReturnDate;
    private boolean returned;

    public LoanDTO() {}

    public LoanDTO(Long id, Long userId, String userName, Long bookCopyId, String bookTitle, LocalDate loanDate, 
                   LocalDate returnDate, LocalDate expecteReturnDate, boolean returned) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.bookCopyId = bookCopyId;
        this.bookTitle = bookTitle;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.expecteReturnDate = expecteReturnDate;
        this.returned = returned;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getBookCopyId() {
		return bookCopyId;
	}

	public void setBookCopyId(Long bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getExpecteReturnDate() {
		return expecteReturnDate;
	}

	public void setExpecteReturnDate(LocalDate expecteReturnDate) {
		this.expecteReturnDate = expecteReturnDate;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

}
