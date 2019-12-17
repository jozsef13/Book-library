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
	private String bookReleaseYear;
	@ApiModelProperty(notes = "The books category")
	private String bookCategory;
	@ApiModelProperty(notes = "The books price")
	private double bookPrice;

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

	public String getBookReleaseYear() {
		return bookReleaseYear;
	}

	public void setBookReleaseYear(String bookReleaseDate) {
		this.bookReleaseYear = bookReleaseDate;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double d) {
		this.bookPrice = d;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookReleaseDate="
				+ bookReleaseYear + ", bookCategory=" + bookCategory + ", bookPrice=" + bookPrice + "]";
	}

}
