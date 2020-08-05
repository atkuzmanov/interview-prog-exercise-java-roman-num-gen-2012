/**
 * 
 */
package com.romannumgen.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.romannumgen.utility.RomanNumeralGeneratorImpl;

/**
 * @author Atanas Kuzmanov
 *
 */
public class ARomanNumeralGeneratorImplShould {

	private RomanNumeralGeneratorImpl rngi;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rngi = new RomanNumeralGeneratorImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		rngi = null;
		System.gc();
	}

	@Test
	public void NotReturnAnEmptyString() {
		assertNotSame("", rngi.generate(1));
	}
	
	@Test(expected = NumberFormatException.class)
	public void checkTheNumberRangeAndThrowExceptionIfWrong(){
		rngi.generate(-1);
		rngi.generate(0);
		rngi.generate(40001);
	}
	
	@Test
	public void notHaveANullConstantArrayOfRomanNumber(){
		assertNotSame(null, rngi.getRomanSymbolTable());
	}
	
	@Test
	public void returnCorrectResult(){
		assertEquals("I", rngi.generate(1));
		assertEquals("V", rngi.generate(5));
		assertEquals("X", rngi.generate(10));
		assertEquals("XX", rngi.generate(20));
		assertEquals("MMMCMXCIX", rngi.generate(3999));
		assertEquals("III", rngi.generate(3));
	}
	
}
