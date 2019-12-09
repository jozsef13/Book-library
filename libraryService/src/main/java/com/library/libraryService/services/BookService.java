package com.library.libraryService.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.libraryService.modules.Author;
import com.library.libraryService.modules.Book;

@Service
public class BookService {

	private Hashtable<Integer, Book> books = new Hashtable<Integer, Book>();
	private Integer key = 1;

	public BookService() {
		Author a = new Author();
		a.setAuthorId(1);
		a.setAuthorFirstName("Gabriel");
		a.setAuthorLastName("Simon");
		
		Book b = new Book();
		b.setBookId(key);
		b.setBookName("ScHoOl");
		b.setBookAuthor(a);
		b.setBookCategory("Horror");
		b.setBookPrice(10.99);
		b.setBookReleaseYear("2012");
		books.put(key, b);
		key++;
		
		a = new Author();
		a.setAuthorId(2);
		a.setAuthorFirstName("Gica");
		a.setAuthorLastName("Hagi");
		
		b = new Book();
		b.setBookId(key);
		b.setBookName("Ai n-ai mingea");
		b.setBookAuthor(a);
		b.setBookCategory("Sport");
		b.setBookPrice(49.50);
		b.setBookReleaseYear("2019");
		books.put(key, b);
		key++;
		
		a = new Author();
		a.setAuthorId(3);
		a.setAuthorFirstName("Stephen");
		a.setAuthorLastName("King");
		
		b = new Book();
		b.setBookId(key);
		b.setBookName("The mist");
		b.setBookAuthor(a);
		b.setBookCategory("Horror");
		b.setBookPrice(54.95);
		b.setBookReleaseYear("1980");
		books.put(key, b);
		key++;
		
		b = new Book();
		b.setBookId(key);
		b.setBookName("IT");
		b.setBookAuthor(a);
		b.setBookCategory("Horror");
		b.setBookPrice(80);
		b.setBookReleaseYear("1986");
		books.put(key, b);
		key++;
		
		a = new Author();
		a.setAuthorId(4);
		a.setAuthorFirstName("Dan");
		a.setAuthorLastName("Brown");
		
		b = new Book();
		b.setBookId(key);
		b.setBookName("Inferno");
		b.setBookAuthor(a);
		b.setBookCategory("Mystery");
		b.setBookPrice(79.99);
		b.setBookReleaseYear("2013");
		books.put(key, b);
		key++;
		
		b = new Book();
		b.setBookId(key);
		b.setBookName("Origin");
		b.setBookAuthor(a);
		b.setBookCategory("Mystery");
		b.setBookPrice(89.99);
		b.setBookReleaseYear("2017");
		books.put(key, b);
		key++;
		
		b = new Book();
		b.setBookId(key);
		b.setBookName("The Da Vinci Code");
		b.setBookAuthor(a);
		b.setBookCategory("Mystery");
		b.setBookPrice(49.99);
		b.setBookReleaseYear("2003");
		books.put(key, b);
		key++;
	}

	public void add(Book book) {
		book.setBookId(key);
		books.put(key , book);
		key++;
	}

	public Book findById(int bookId) {
		if(books.containsKey(bookId)){
			return books.get(bookId);
		}
		
		return null;
	}

	public List<Book> findByBookAuthor(int authorId) {
		
		List<Book> returningBooks = new ArrayList<>();
		Collection<Book> bookValues = books.values();
		
		for (Book book : bookValues) {
			if(book.getBookAuthor().getAuthorId() == authorId){
				returningBooks.add(books.get(book.getBookId()));
			}
		}
		
		if(returningBooks.isEmpty()){
			return null;
		}
		
		return returningBooks;
	}

	public List<Book> findByBookCategory(String bookCategory) {

		List<Book> returningBooks = new ArrayList<>();
		Collection<Book> bookValues = books.values();
			
		for (Book book : bookValues) {
			if(book.getBookCategory().equals(bookCategory)){
				returningBooks.add(books.get(book.getBookId()));
			}
		}
		
		if(returningBooks.isEmpty()){
			return null;
		}
		
		return returningBooks;	
	}

	public Hashtable<Integer, Book> findAll() {
		return books;
	}

	public void update(Book book, int bookId) {
		books.replace(bookId, book);
	}

	public void delete(int bookId) {
		books.remove(bookId);
	}
}
