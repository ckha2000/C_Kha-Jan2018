package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int column;
	
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        char columnChar = cellName.charAt(0);
        char rowChar = cellName.charAt(1);
        
        row = Character.getNumericValue(rowChar) - 1;
        column = columnChar - 'A';
    }

}
