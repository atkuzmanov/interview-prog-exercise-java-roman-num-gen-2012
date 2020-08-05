package com.romannumgen.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.romannumgen.view.RomView;

public class ARomViewShould {

	private static RomView rv;
	
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		rv = new RomView();
	}

	@AfterClass
	public static void oneTimeTearDown() throws Exception {
		rv = null;
		System.gc(); //Suggestion to JVM to run Garbage Collector for memory cleanup.
	}
	
	@Test
	public void useTheRomClientControllerCorrectlyAndReturnCorrectResults(){
		assertEquals("I", rv.useRomClientController(1));
		assertEquals("V", rv.useRomClientController(5));
		assertEquals("X", rv.useRomClientController(10));
		assertEquals("XX", rv.useRomClientController(20));
		assertEquals("MMMCMXCIX", rv.useRomClientController(3999));
		assertEquals("III", rv.useRomClientController(3));
	}

}
