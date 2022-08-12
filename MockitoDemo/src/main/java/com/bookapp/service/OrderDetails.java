package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;


public class OrderDetails {

	IBookService bookService;

	public void setBookService(IBookService bookService) {
		this.bookService=bookService;
	}

	public String showMessage(String name) {
		String result=bookService.greetMessage();
		if(name.startsWith("P"))
			return result.concat(" ").concat(name);

		else
			return "Wrong username";
	}

	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		//System.out.println("In orderdetails");
		List<Book>books=bookService.getAll(); //has to proxied
		if(books==null)
			return null;
		if(books.isEmpty())
			throw new BookNotFoundException();
		return books.stream().filter(book->book.getAuthor().equals(author))
				.sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
				.collect(Collectors.toList());

	}

	public String orderBook(int bookId) throws BookNotFoundException {
		try {
			Book book=bookService.getById(bookId);
			if(book==null)
				return "Out of Stock";

			return "Book ordered";
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Technical Issues";

	}

	public String addBook(Book book) {
		if(book==null)
			return "Book not added";
		bookService.addBook(book);
		return "Book added";
		
	}
}
