package com.testcases.demo.check;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.training.User;

class UserTest {
	User user;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		user=null;
	}

	@Test
	@DisplayName("Testing greet")
	@Tag("greet")
	void testGreet() {
		String username="Priya";
		assertEquals("Welcome"+username, user.greet(username));
	}
	@Test
	@DisplayName("Testing fruits")
	void testshowFruits() {
		assertEquals(Arrays.asList("Strawberry","Mango","Grapes"), user.showFruits());
		
	}
	@Test
	@DisplayName("Testing fruits length")
	void testFruitsLength() {
		
		assertEquals(3, user.showFruits().size());
		
	}


}
