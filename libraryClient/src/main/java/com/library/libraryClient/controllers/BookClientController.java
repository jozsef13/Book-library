package com.library.libraryClient.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.library.libraryClient.clients.BookClient;
import com.library.libraryService.modules.Book;

@RestController
@RequestMapping(BookClientController.CONTRACT_BASE_URL)
public class BookClientController {

	public static final String CONTRACT_BASE_URL = "/books";
	@Autowired
	private BookClient bc;

	@GetMapping("/id/{bookId}")
	public ModelAndView getBook(@PathVariable int bookId, HttpSession session) {
		ModelAndView model = new ModelAndView("addToBasket");
		Book book = bc.getBook(bookId);
		model.addObject(book);
		session.setAttribute("bookId", bookId);
		return model;
	}

	@GetMapping("/allBooks")
	public ModelAndView getBooks() {
		ModelAndView model = new ModelAndView("booksInventory");
		List<Book> books = new ArrayList<Book>(bc.getBooks());
		model.addObject("books", books);
		return model;
	}

	@PostMapping("/addBook")
	public void addBook(Book newBook) {
		bc.addBook(newBook);
	}

	@GetMapping("/author/{authorId}")
	public List<Book> getBookByAuthorId(@PathVariable int authorId) {
		return bc.getBookByAuthorId(authorId);
	}

	@GetMapping("/category/{bookCategory}")
	public List<Book> getBookByCategory(@PathVariable String category) {
		return bc.getBookByCategory(category);
	}
}
