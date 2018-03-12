package textExcel;

public class TextCell implements Cell {
	String text;
	
	public TextCell(String input) {
		text = input;
	}
	
	@Override
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		if(text.length() > 10) {
			return text.substring(0, 9);
		} else {
			String returnString = text;
			for(int i = 0; i < (10 - text.length()); i++ ) {
				returnString += " ";
			}
			return returnString;
		}
	}

	@Override
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
	}

}
