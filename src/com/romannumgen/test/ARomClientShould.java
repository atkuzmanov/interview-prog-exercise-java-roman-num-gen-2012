package com.romannumgen.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.romannumgen.controller.RomClient;
import com.romannumgen.utility.RomanNumeralGeneratorImpl;

public class ARomClientShould {

	private static RomClient rc;
	private static RomanNumeralGeneratorImpl rngi;
	
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		rc = new RomClient();
		rngi = new RomanNumeralGeneratorImpl();
	}

	@AfterClass
	public static void oneTimeTearDown() throws Exception {
		rc = null;
		rngi = null;
		System.gc();
	}

	@Test
	public void allowItsRomanNumeralGeneratorImplToBeSet() {
		rc.setRNGI(rngi);
		assertEquals(rngi, rc.getRNGI());
	}
	
	@Test
	public void notHaveANullReferenceForItsRomanNumeralGeneratorImpl(){
		assertNotSame(null, rc.getRNGI());
	}
	
	@Test
	public void invokeTheCorrectFunctionalityAndReturnTheCorrectResult(){
		assertEquals("I", rc.invokeClient(1));
		assertEquals("V", rc.invokeClient(5));
		assertEquals("X", rc.invokeClient(10));
		assertEquals("XX", rc.invokeClient(20));
		assertEquals("MMMCMXCIX", rc.invokeClient(3999));
		assertEquals("III", rc.invokeClient(3));
	}
	
}
