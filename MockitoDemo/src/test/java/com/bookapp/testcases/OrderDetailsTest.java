package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)


class OrderDetailsTest {

	@Mock  //create a proxy
	IBookService bookservice; //mock IBookservice
	
	//create an object of orderdetails and inject bookservice
	//equivalent to
	//details=new OrderDetails();
	//details.setBookService(bookservice);
	
	@InjectMocks
	OrderDetails details;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@Test
	void testShowMessage() {
		//using the mock object call the method of bookservice
		Mockito.when(bookservice.greetMessage()).thenReturn("Great Day");
		//this is the method to be tested
		String actual=details.showMessage("Priya"); //called first
		assertEquals("Great Day Priya",actual);
		String nactual=details.showMessage("Prachi"); //called 
		assertEquals("Great Day Prachi",nactual);
	}
	
	void testAnsShowMessage() {
		//using the mock object call the method of bookservice
		Mockito.when(bookservice.greetMessage()).thenReturn("Great Day");
		//this is the method to be tested
		String actual=details.showMessage("Raj"); //called first
		assertEquals("Wrong username",actual);
		String nactual=details.showMessage("Helen"); //called first
		assertEquals("Wrong username",nactual);
	}
	
	
	Book book1,book2,book3,book4;
	List<Book> bookList=null;

	@BeforeEach
	void setUp() throws Exception {
		book1=new Book(1,"Java","Kathy",900);
		book2=new Book(2,"Spring","Robin",900);
		book3=new Book(3,"JSP","Rhonde",900);
		book4=new Book(4,"Monk","Robin",900);
		bookList=Arrays.asList(book1,book2,book3,book4);
		
  	}
	@Test
	@DisplayName("Testing by author -name")
	void testGetByAuthor() throws BookNotFoundException {
		String author="Robin";
		when(bookservice.getAll()).thenReturn(bookList);
		List<Book> actualBooks=details.findByAuthor(author);
		List<Book> expectedBooks=Arrays.asList(book4,book2);
		assertEquals(expectedBooks,actualBooks);
	}
	@Test
	@DisplayName("Testing by author- throw exceptiom")
	void testGetByAuthorException() throws BookNotFoundException {
		String author="Priya";
		when(bookservice.getAll()).thenThrow(new BookNotFoundException());
		
		assertThrows(BookNotFoundException.class,()->{
			details.findByAuthor(author);
		});
	}
	
	@Test
	@DisplayName("Testing by author- empty list")
	void testGetByAuthorEmpty() throws BookNotFoundException {
		String author="Priya";
		List<Book> emptyList=new ArrayList<>();
		when(bookservice.getAll()).thenReturn(emptyList);
		
		assertThrows(BookNotFoundException.class,()->{
			details.findByAuthor(author);
		});
	}
	
	@Test
	@DisplayName("Testing by author- null")
	void testGetByAuthorNull() throws BookNotFoundException {
		String author="Priya";
		when(bookservice.getAll()).thenReturn(null);
		List<Book>actualBooks=details.findByAuthor(author);
		assertNull(actualBooks);
		
		};
	

	@AfterEach
	void tearDown() throws Exception {
		details=null;
	}

}
