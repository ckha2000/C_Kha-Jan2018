package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{
	private static Spreadsheet userSheet;
	
	public static Spreadsheet getSheet() {
		return userSheet;
	}
	
	public static void main(String[] args)
	{
	    Scanner userInput = new Scanner(System.in);
	    //Spreadsheet 
	    userSheet = new Spreadsheet();
	    
	    boolean isRunning = true;
	    
	    while(isRunning) {
	    	String command = userInput.nextLine();
	    	if(command.toLowerCase().equals("quit")) {
	    		isRunning = false;
	    	} else {
	    		System.out.println(userSheet.processCommand(command));
	    	}
	    }
	    
	    userInput.close();
	}
}
