//Christopher Kha	Period 2
// 3/16/18
// Main method loop - handles user input

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel
{	
	public static void main(String[] args)
	{
	    Scanner userInput = new Scanner(System.in);
	    Spreadsheet userSheet = new Spreadsheet();
	    
	    boolean isRunning = true;
	    
	    //checks for the user to type quit - if not, it uses the Spreadsheet class's processCommand
	    //and returns the string
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
