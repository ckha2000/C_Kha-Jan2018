package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cellGrid = new Cell[getRows()][getCols()];
	
	public Spreadsheet() {
		makeEmptySheet();
	}
	
	@Override
	public String processCommand(String command)
	{
		String[] parsedCommand = command.split(" ");
		Location loc;
		
		if(command.contains(" = ")){		// <cell> = <value>
			String[] c = command.split(" = ");
			
			loc = new SpreadsheetLocation(c[0]);
			cellGrid[loc.getRow()][loc.getCol()] = new TextCell(c[1].replace("\"", ""));
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

	public void makeEmptySheet(){
		for(int r = 0; r < getRows(); r++){
			for(int c = 0; c < getCols(); c++){
				cellGrid[r][c] = new EmptyCell();
			}
		}
	}
	
	public void assignCell(String input) {
		
	}
	
	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return cellGrid[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String gridString = "   ";
		for(char i = 'A'; i < 'M'; i++){
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
