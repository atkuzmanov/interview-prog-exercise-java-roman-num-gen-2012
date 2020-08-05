package com.romannumgen.utility;

import com.romannumgen.interfaces.RomanNumeralGenerator;
import com.romannumgen.model.RomanNumber;

/*
 * Class for converting Arabic numbers to Roman numbers.
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
	//Constant - so no setter method.
	private final static RomanNumber[] ROMAN_SYMBOL_TABLE = {
	        new RomanNumber(1000, "M"),
	        new RomanNumber(900, "CM"),
	        new RomanNumber(500, "D"),
	        new RomanNumber(400, "CD"),
	        new RomanNumber(100, "C"),
	        new RomanNumber(90, "XC"),
	        new RomanNumber(50, "L"),
	        new RomanNumber(40, "XL"),
	        new RomanNumber(10, "X"),
	        new RomanNumber(9, "IX"),
	        new RomanNumber(5, "V"),
	        new RomanNumber(4, "IV"),
	        new RomanNumber(1, "I")
	    };
	
	/*
	 * (non-Javadoc)
	 * @see com.romannumgen.interfaces.RomanNumeralGenerator#generate(int)
	 * Method "generate" converts an integer number to it's Roman representation.
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the bookings StringBuffer object monitor
	 * for fine grained locking as this method might be used by several controllers.
	 * @param int - the number to be converted
	 * @return String - the resulting Roman representation
	 */
	@Override
	public String generate(int number) {
	    if (number >= 4000  || number < 1) {
            throw new NumberFormatException("Numbers must be in range 1 - 3999!");
        }
        StringBuffer result = new StringBuffer(10);
        synchronized (result) { //Fine-grained locking to achieve thread-safeness.
        	//Start with the largest value, and work towards the smallest.
	        for (RomanNumber rn : ROMAN_SYMBOL_TABLE) {
	            //Remove as many of this value as possible (maybe none).
	            while (number >= rn.getIntVal()) {
	                number -= rn.getIntVal();      //Subtract value.
	                result.append(rn.getRomVal()); //Add roman equivalent.
	            }
	        }
	        return result.toString();
        }
	}
	
	//Constant getter method for future functionality.
	public RomanNumber[] getRomanSymbolTable() {
		return ROMAN_SYMBOL_TABLE;
	}
	
}
