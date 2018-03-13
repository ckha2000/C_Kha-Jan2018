package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cellGrid = new EmptyCell[getRows()][getCols()];
	
	public Spreadsheet() {
		for(int r = 0; r < getRows(); r++){
			for(int c = 0; c < getCols(); c++){
				cellGrid[r][c] = new EmptyCell();
			}
		}
		
	}
	
	@Override
	public String processCommand(String command)
	{
		return "";
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
