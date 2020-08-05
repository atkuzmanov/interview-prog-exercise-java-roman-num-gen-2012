package com.romannumgen.view;

import java.util.Scanner;

import com.romannumgen.controller.RomClient;
import com.romannumgen.interfaces.GenericView;

/*
 * @author Atanas Kuzmanov
 * A class which performs the responsibility of a View
 * by showing relevant data to the user.
 */
public class RomView implements GenericView{
	
	private static Scanner in;
	private static RomView rv;
	
	/*
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args){
		try{
			rv = new RomView();
			rv.loadInterface();
		} catch (NumberFormatException e) {
			System.err.println("---[ERROR - Invalid Input!]---");
			System.err.println(e.getMessage());
			//e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("---[ERROR! - NullPointerExceotion]---");
			//e.printStackTrace();
		} catch (Exception e) {
			System.err.println("---[ERROR!]---");
			//e.printStackTrace();
		}
	}
	
	/*
	 * Method "loadInterface" which calls the relevant Controller and 
	 * shows the relevant information to the user. 
	 * The method is synchronized in order to be thread safe in case
	 * the RomView is used by several users at the same time. 
	 * Future development of this function might be to pass a Controller as a parameter
	 * and become more generic, and do processing relevant to that controller, 
	 * but not required at present stage which is for demonstration purpose.
	 */
	public synchronized void loadInterface(){
		in = new Scanner(System.in);
		if(in != null){
			System.out.println("Please enter a number between 1 and 3999 or \"!quit\" to exit: ");
			while (in.hasNext()) {
				String input = in.nextLine();
				if (input.equals("!quit")) {
					System.out.println("Exiting...");
					cleanUp();
				} else {
					System.out.print("The roman representation of the arabic number " + input + " is ");
					System.out.print(useRomClientController(Integer.parseInt(input)) + "\n");
				}
			}
		} else {
			cleanUp();
		}
	}
	
	/*
	 * Memory cleanup, preventing memory leaks of open streams.
	 */
	public void cleanUp(){
		in.close();
		System.gc(); //Suggestion to JVM to run the Garbage Collector. 
		System.exit(0);
	}
	
	/*
	 * Method "useRomClientController" which invokes the
	 * relevant client (controller) and passes the number to be processed.
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the bookings romanClient object
	 * for fine grained locking as there might be several RomViews used at the same time
	 * by different users.
	 * @param int number - the number to be processed.
	 * @return the resulting Roman representation of the processed number.
	 */
	public String useRomClientController(int number){
		RomClient rc = new RomClient();
			synchronized (rc) {
				return rc.invokeClient(number);
			}
	}
	
}
