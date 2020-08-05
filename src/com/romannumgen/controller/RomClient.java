package com.romannumgen.controller;

import com.romannumgen.interfaces.GenericClient;
import com.romannumgen.utility.RomanNumeralGeneratorImpl;

/*
 * @author Atanas Kuzmanov
 * A class which performs the responsibility of a Controller
 * by invoking the relevant functionality.
 */
public class RomClient implements GenericClient {
	
	private RomanNumeralGeneratorImpl rngi;
	
	public RomanNumeralGeneratorImpl getRNGI() {
		return this.rngi;
	}

	public void setRNGI(RomanNumeralGeneratorImpl rngi) {
		this.rngi = rngi;
	}
	
	/*
	 * The invokeClient method creates a new Roman number generator
	 * and passes the Arabic number to be converted.
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the bookings RomanNumeralGeneratorImpl 
	 * object monitor for fine grained locking as there might be several invocations of this controller
	 * by several views.
	 * @param int - decimal number
	 * @return String - the Representation of the decimal number
	 */
	public String invokeClient(int number) throws NumberFormatException {
		if(rngi == null){
			rngi = new RomanNumeralGeneratorImpl();
		}
		synchronized (rngi) {
			return rngi.generate(number);
		}
	}

}
