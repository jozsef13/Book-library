package com.library.libraryClient.clients;

import java.util.Collection;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.library.libraryService.modules.Book;

@Component
public class BookClient {
	
	private String url;
	@Autowired
	private RestOperations restOperations;
	
	@Autowired
	public BookClient(@Value("${service.url}") String url)
	{
		this.url = url;
	}
	
	public Book getBook(int bookId)
	{	
		final String uri = url + "books/id/" + bookId;
		
		return restOperations.getForObject(uri, Book.class);
	}
	
	public Collection<Book> getBooks()
	{
		final String uri = url + "books/allBooks";
		
		Hashtable<Integer, Book> books = restOperations.getForObject(uri, Hashtable.class);
		Collection<Book> booksList = books.values();
		
		return booksList;
	}
	
	public void addBook(Book newBook)
	{
		final String uri = url + "books/addBook";
		
		restOperations.postForObject(uri, newBook, Book.class);
	}

	public Collection<Book> getBookByAuthorId(int authorId) {
		final String uri = url + "books/author/" + authorId;
		
		Hashtable<Integer, Book> books = restOperations.getForObject(uri, Hashtable.class);
		Collection<Book> booksList = books.values();
		
		return booksList;
	}

	public Collection<Book> getBookByCategory(String category) {
		final String uri = url + "books/category/" + category;
		
		Hashtable<Integer, Book> books = restOperations.getForObject(uri, Hashtable.class);
		Collection<Book> booksList = books.values();
		
		return booksList;
	}
}
