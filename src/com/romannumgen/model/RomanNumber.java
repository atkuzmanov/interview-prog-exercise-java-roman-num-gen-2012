package com.romannumgen.model;

import com.romannumgen.interfaces.RomanNum;

/*
 * @author Atanas Kuzmanov
 * A class which performs the responsibility of a Model
 * by storing relevant data. This is very similar to a full JavaBean except
 * that it does not have setter methods as this functionality is not required at
 * the present state of the application.
 */
public class RomanNumber implements RomanNum {

	private int intVal;
	private String romVal;
	
	public RomanNumber(int iVal, String sVal){
		this.intVal = iVal;
		this.romVal = sVal;
	}

	public String getRomVal() {
		return romVal;
	}

	public int getIntVal() {
		return intVal;
	}

}
