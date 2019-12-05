package com.library.libraryService.modules;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Details about your books")
public class Book {
	
	@ApiModelProperty(notes = "The primary key, unique id")
	private int bookId;
	@ApiModelProperty(notes = "The books name")
	private String bookName;
	@ApiModelProperty(notes = "The books author")
	private Author bookAuthor;
	@ApiModelProperty(notes = "The books release date")
	private String bookReleaseDate;
	@ApiModelProperty(notes = "The books category")
	private String bookCategory;
	@ApiModelProperty(notes = "Number of copies of this book")
	private int bookNrOfCopies;
	@ApiModelProperty(notes = "The books price")
	private int bookPrice;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Author getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookReleaseDate() {
		return bookReleaseDate;
	}
	public void setBookReleaseDate(String bookReleaseDate) {
		this.bookReleaseDate = bookReleaseDate;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public int getBookNrOfCopies() {
		return bookNrOfCopies;
	}
	public void setBookNrOfCopies(int bookNrOfCopies) {
		this.bookNrOfCopies = bookNrOfCopies;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookReleaseDate="
				+ bookReleaseDate + ", bookCategory=" + bookCategory + ", bookNrOfCopies=" + bookNrOfCopies
				+ ", bookPrice=" + bookPrice + "]";
	}

}
