//Christopher Kha	Period 2
// 3/16/18
// Spreadsheet class - stores a 2d array of Cells and handles userInput
package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cellGrid = new Cell[getRows()][getCols()];
	
	//constructor for Spreadsheet
	public Spreadsheet() {
		makeEmptySheet();
	}
	
	//decides what action to take or what cell to make based on the user input - looks for assignment, clear, 
	//clear cell and cell inspection
	public String processCommand(String command)
	{
		String[] parsedCommand = command.split(" ");
		Location loc;
		
		if(command.contains(" = ")){		// <cell> = <value>
			String[] c = command.split(" = ", 2);
			loc = new SpreadsheetLocation(c[0]);
			
			if(c[1].charAt(0) == '"') {
				cellGrid[loc.getRow()][loc.getCol()] = new TextCell(c[1].replace("\"", ""));
			}else if(c[1].charAt(0) == '(') {
				cellGrid[loc.getRow()][loc.getCol()] = new FormulaCell(c[1], this);
			}else if(c[1].contains("%")){
				cellGrid[loc.getRow()][loc.getCol()] = new PercentCell(c[1]);
			}else{
				cellGrid[loc.getRow()][loc.getCol()] = new ValueCell(c[1]);
			}
			
			return getGridText();	
			
		}else if(command.toLowerCase().contains("clear")){
			if(parsedCommand.length > 1){							// clear <cell>
				loc = new SpreadsheetLocation(parsedCommand[1]);
				cellGrid[loc.getRow()][loc.getCol()] = new EmptyCell();
				
				return getGridText();	
				
			}else{													// clear
				makeEmptySheet();
				return getGridText();	
			
			}
		}else if(command.trim().length() < 4){						// <cell>
			loc = new SpreadsheetLocation(command.trim());
			
			return cellGrid[loc.getRow()][loc.getCol()].fullCellText();
		}
		return "";
	}

	//fills the grid with EmptyCells
	public void makeEmptySheet(){
		for(int r = 0; r < getRows(); r++){
			for(int c = 0; c < getCols(); c++){
				cellGrid[r][c] = new EmptyCell();
			}
		}
	}
	
	//returns the number of rows in the spreadsheet
	public int getRows()
	{
		return 20;
	}

	//returns the number of columns in the spreadsheet
	public int getCols()
	{
		return 12;
	}

	//returns the cell at the given location
	public Cell getCell(Location loc)
	{
		return cellGrid[loc.getRow()][loc.getCol()];
	}

	//returns the structured grid with all the values in the right place
	public String getGridText()
	{
		String gridString = "   ";
		for(char i = 'A'; i < 'A' + getCols(); i++){
			gridString += "|" + i + "         ";
		}
		gridString += "|\n";
		
		for(int r = 0; r < getRows(); r++){
			gridString += (r+1);
			if(r < 9){
				gridString += "  ";
			}else{
				gridString += " ";
			}
					
			for(int c = 0; c < getCols(); c++){
				gridString += "|" + cellGrid[r][c].abbreviatedCellText();
			}
			gridString += "|\n";
			
		}
		
		return gridString;
	}

}
