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
        char[] rowChar = new char[2];
        if(cellName.length() > 2) {
        	rowChar[0] = cellName.charAt(1);
        	rowChar[1] = cellName.charAt(2);
        }else {
        	rowChar[0] = '0';
        	rowChar[1] = cellName.charAt(1);
        }
       
        
        row = Character.getNumericValue(rowChar[0])*10 + Character.getNumericValue(rowChar[1]) - 1;
        column = Character.toUpperCase(columnChar) - 'A';
    }

}
