package com.romannumgen.interfaces;

/**
 * @author Atanas Kuzmanov
 * This interface is provided for expanding view capabilities
 * when scaling the application by specifying common functionality for all views here. 
 *
 * GenericView is a template for a class which performs the responsibility of a View in an MVC pattern
 * by invoking the relevant functionality.
 */
public interface GenericView {
	
	public abstract void loadInterface();
	
}
