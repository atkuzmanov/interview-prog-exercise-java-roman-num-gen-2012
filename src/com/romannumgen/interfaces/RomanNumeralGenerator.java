package com.romannumgen.interfaces;

/**
 * This interface is provided for expanding RomanNumeralGenerator capabilities
 * when scaling the application by specifying common functionality for all RomanNumeralGenerators here. 
 */
public interface RomanNumeralGenerator {

	public String generate(int number);
	
}
