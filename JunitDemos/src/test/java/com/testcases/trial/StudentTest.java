package com.testcases.trial;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.exception.*;
import com.vfislk.training.Student;

class StudentTest {
	Student student;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student=new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student=null;
	}

	@Test
	void testCalcTotal() throws NegativeValueException, InvaliedNumberException {
		assertEquals(150,student.calcTotal(50, 50, 50));
	}
	@Test @DisplayName("Testing negative value")
	void testNeagtive() {

		assertThrows(NegativeValueException.class,()->student.calcTotal(-90,60,80));
	}
	@Test @DisplayName("Testing greater value")
	void testGreaterTotal(){

		assertThrows(InvaliedNumberException.class,()->student.calcTotal(120,160,180));
	}
	@Test @DisplayName("Testing grade - A")
	void testGetGradeA() throws InvaliedNumberException {
		int[] marks= {98,95,90};
		String grade=student.getGrade(marks);
		assertEquals("A",student.getGrade(marks));
	}
	@Test @DisplayName("Testing grade - B")
	void testGetGradeB() throws InvaliedNumberException {
		int[] marks= {88,85,80};
		String grade=student.getGrade(marks);
		assertEquals("B",student.getGrade(marks));
	}
	@Test @DisplayName("Testing grade - C")
	void testGetGradeC() throws InvaliedNumberException {
		int[] marks= {78,74,70};
		String grade=student.getGrade(marks);
		assertEquals("C",student.getGrade(marks));
	}
	@Test @DisplayName("Testing grade - D")
	void testGetGradeD() throws InvaliedNumberException {
		int[] marks= {68,64,60};
		String grade=student.getGrade(marks);
		assertEquals("D",student.getGrade(marks));
	}
	@Test @DisplayName("Testing grade - E")
	void testGetGradeE() throws InvaliedNumberException {
		int[] marks= {58,54,60};
		String grade=student.getGrade(marks);
		assertEquals("E",student.getGrade(marks));
	}
	
	@Test @DisplayName("insert marks")
	@Tag("Fail")
	void testGetGradeFail() throws InvaliedNumberException {
		int[] marks= {10,20,40};
		String grade=student.getGrade(marks);
		assertNull(null,student.getGrade(marks));
	}



}
