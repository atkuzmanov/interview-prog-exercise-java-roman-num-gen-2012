package com.romannumgen.interfaces;

/**
 * @author Atanas Kuzmanov
 * This interface is provided for expanding Roman number capabilities
 * when scaling the application by specifying common functionality for all Roman numbers here. 
 */
public interface RomanNum {

	public abstract int getIntVal();
	public abstract String getRomVal();
	
}
