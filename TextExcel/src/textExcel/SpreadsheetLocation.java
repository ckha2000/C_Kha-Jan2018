//Christopher Kha	Period 2
// 3/16/18
// SpreadsheetLocation class - parses the cell name into the row and column number and stores the values
package textExcel;

public class SpreadsheetLocation implements Location
{
	//stored row and column
	private int row;
	private int column;
	
    //returns the row
    public int getRow()
    {
        return row;
    }

    //returns the column
    public int getCol()
    {
        return column;
    }
    
    // constructor of SpreadsheetLocation - parses the cell name
    public SpreadsheetLocation(String cellName)
    {
        char columnChar = cellName.charAt(0);
        String rowString = cellName.substring(1);
        
        row = Integer.valueOf(rowString) - 1;
        column = Character.toUpperCase(columnChar) - 'A';
    }

}
