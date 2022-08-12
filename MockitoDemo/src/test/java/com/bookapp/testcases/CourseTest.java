package com.bookapp.testcases;

import static org.junit.Assert.assertEquals;


import static org.junit.jupiter.api.Assertions.*;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.model.Book;
import com.bookapp.service.Course;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)


class CourseTest {
	
	@Spy
	Course course; // creates an instance of course
	
	@Mock
	Course mcourse; // create an proxy of course
	
	@Test
	void testShowCourses() {
		List<String> courses=course.showCourses();
		System.out.println(courses);
	}
	
	@Test
	
	void testCoursesMock() {
		when(mcourse.showCourses()).thenReturn(Arrays.asList("Java"));
		List<String>courses=mcourse.showCourses();
		System.out.println(courses);
		
	}
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	@DisplayName("testing courses")
	void testCourses() {
		List<String> expectedcourse=Arrays.asList("Java","Spring","Angualr");
		assertEquals(expectedcourse, course.showCourses());
		assertNotNull(expectedcourse);
	}

	@BeforeEach
	void setUp() throws Exception {
		course=new Course();
	}

	@AfterEach
	void tearDown() throws Exception {
		course=null;
	
	}
	
	}


