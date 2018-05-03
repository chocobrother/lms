package com.cafe24.inheritance.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID") 
public class Book extends Item {
		
	private String isbn;



	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", getId()=" + getId() + ", getName()=" + getName() + ", getState()=" + getState()
				+ "]";
	}
	
	

}
