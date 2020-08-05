package com.romannumgen.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.romannumgen.model.RomanNumber;

public class ARomanNumberShould {

	private RomanNumber rn;
	@Before
	public void setUp() throws Exception {
		rn = new RomanNumber(1, "I");
	}

	@After
	public void tearDown() throws Exception {
		rn = null;
		System.gc();
	}
	
	@Test
	public void allowToGetIntValWhichIsSetViaConstructor() {
		assertEquals(1, rn.getIntVal());
	}
	
	@Test
	public void allowToGetRomValWhichIsSetViaConstructor() {
		assertEquals("I", rn.getRomVal());
	}
	
}
