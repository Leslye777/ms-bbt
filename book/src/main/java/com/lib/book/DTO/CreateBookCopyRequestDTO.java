package com.lib.book.DTO;

public class CreateBookCopyRequestDTO {
		
    private Long bookId;
    private Long numberOfCopies;
    
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(Long numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
}
