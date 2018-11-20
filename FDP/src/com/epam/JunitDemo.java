package com.epam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class JunitDemo {

	static int beforeClassCount = 1;
	static int afterClassCount = 1;
	static int beforeCount = 1;
	static int afterCount = 1;
	
	@BeforeClass
	static void setUpClass()  {
		System.out.println("before class "+ beforeClassCount);
	}

	@AfterClass
	static void tearDownAfterClass()  {
		System.out.println(" after class "+afterClassCount);
	}

	@Before
	void setUp() throws Exception {
		System.out.println("before "+ beforeCount);
	}

	@After
	void tearDown() throws Exception {
		System.out.println("after "+afterCount);
	}

	@Test
	void test1() {
		System.out.println("in test1");
		assertEquals("Raju", "Raju");
	}
	
	@Test
	void test2() {
		System.out.println("in test2");
	}

	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
