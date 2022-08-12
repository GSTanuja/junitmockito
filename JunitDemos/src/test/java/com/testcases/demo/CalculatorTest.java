package com.testcases.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vfislk.training.Calculator;

class CalculatorTest {
	Calculator calculator;
	@BeforeAll
	public static void init() {
		System.out.println("called before all the testcases");
	}
	@BeforeEach
	public  void setUp() {
		calculator=new Calculator();
		System.out.println("called before each testcases");
	}
	@Test
	public void testAdd() {
		System.out.println("Testing");
		int actual=calculator.sum(10, 20);
		assertEquals(30,actual);
	}
	@Test
	public void testProduct() {
		System.out.println("Testing");
		int actual=calculator.product(10, 20);
		assertEquals(200,actual);
	}

	@AfterEach
	public  void teardown() {
		calculator=null;
		System.out.println("called after each testcases");
	}
	@AfterAll
	public static void cleanup() {
		System.out.println("called after all the testcases");
	}



}
