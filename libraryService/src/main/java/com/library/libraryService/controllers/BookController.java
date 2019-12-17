package com.library.libraryService.controllers;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.libraryService.modules.Book;
import com.library.libraryService.services.BookService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(BookController.CONTRACT_BASE_URL)
@ApiModel(description = "Everything about books")
public class BookController {

	@Autowired
	private BookService bs;
	public static final String CONTRACT_BASE_URL = "/books";

	@PostMapping("/addBook")
	@ApiOperation(value = "Add books to the database", response = Book.class)
	private Book addBook(@ApiParam(value = "Book object that needs to be added to the store") @RequestBody Book book) {
		bs.add(book);
		return book;
	}

	@GetMapping("/id/{bookId}")
	@ApiOperation(value = "Finds a book by its id", response = Book.class)
	private Book getBookById(@ApiParam(value = "ID of book to return") @PathVariable int bookId) {
		return bs.findById(bookId);
	}

	@GetMapping("/author/{authorId}")
	@ApiOperation(value = "Finds a book by its authors ID", response = Book.class)
	private List<Book> getBooksByAuthor(@ApiParam(value = "Author of the book to return") @PathVariable int authorId) {
		return bs.findByBookAuthor(authorId);
	}

	@GetMapping("/category/{bookCategory}")
	@ApiOperation(value = "Finds a book by its category", response = Book.class)
	private List<Book> getBookByCategory(@ApiParam(value = "Category of book to return") @PathVariable String bookCategory) {
		return bs.findByBookCategory(bookCategory);
	}

	@GetMapping("/allBooks")
	@ApiOperation(value = "Finds all the books", response = Book.class)
	private Hashtable<Integer, Book> getAllBooks() {
		return bs.findAll();
	}

	@PutMapping("/updateBook/{bookId}")
	@ApiOperation(value = "Updates a book", response = Book.class)
	private Book updateBookInfo(@ApiParam(value = "Book object to be updated") @RequestBody Book book, @ApiParam(value = "ID of the book object to be updated") @PathVariable int bookId) {
		bs.update(book, bookId);
		return book;
	}

	@DeleteMapping("/deleteBook/{bookId}")
	@ApiOperation(value = "Deletes a book", response = Book.class)
	private String deleteBook(@ApiParam(value = "ID of the book that is going to be deleted") @PathVariable int bookId) {
		bs.delete(bookId);
		return "Deleted successfully";
	}
}
