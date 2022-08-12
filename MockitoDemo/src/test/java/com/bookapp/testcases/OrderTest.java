package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderTest {

	@Mock
	IBookService bookService;
	@InjectMocks
	OrderDetails details;

	List<Book> bookList;
	Book book1,book2,book3,book4;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	@BeforeEach
	void setUp() throws Exception {
		book1=new Book(1,"Java","Kathy",900);
		book2=new Book(2,"Spring","Robin",900);
		book3=new Book(3,"JSP","Rhonde",900);
		book4=new Book(4,"Monk","Robin",900);
		bookList=Arrays.asList(book1,book2,book3,book4);

	}

	@Test @DisplayName("Testing add Book - ")
	void testAddBook() throws BookNotFoundException{
		doNothing().when(bookService).addBook(book1);
		String actual=details.addBook(book1);
		assertEquals("Book added",actual);
	}

	@Test @DisplayName("Testing add Book - null")
	void testAddBookNull() throws BookNotFoundException{
		String actual=details.addBook(null);
		assertEquals("Book not added",actual);
	}
	@Test @DisplayName("Testing Book - returns one book instance")
	void testBookById() throws BookNotFoundException{
		when(bookService.getById(1)).thenReturn(book1);
		//call the method using mox=ck object
		//doReturn(book1).when(bookService).getById(1);
		String actual=details.orderBook(1);
		assertEquals("Book ordered",actual);
	}

	@Test @DisplayName("Testing Book - returns null")
	void testBookByIdNull() throws BookNotFoundException{

		//call the method using mox=ck object
		doReturn(null).when(bookService).getById(10);
		String actual=details.orderBook(10);
		assertEquals("Out of Stock",actual);
	}

	@Test @DisplayName("Testing Book - throws exception")
	void testBookByIdException() throws BookNotFoundException{

		//call the method using mox=ck object
		doThrow(new BookNotFoundException("Invalid Id")).when(bookService).getById(20);
		String actual=details.orderBook(2);
		assertEquals("Technical Issues",actual);
	}

	@AfterEach
	void tearDown() throws Exception {
		details=null;
	}


}
