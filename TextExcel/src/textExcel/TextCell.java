//Christopher Kha	Period 2
// 3/16/18
// TextCell - for cells that have text and not numbers - characterized by quotations around the assignment string
package textExcel;

public class TextCell implements Cell { 
	//stores the text in a field
	private String text;
	
	//constructor for TextCell
	public TextCell(String input) {
		text = input;
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		if(text.length() > 10) {
			return text.substring(0, 10);
		} else {
			String returnString = text;
			for(int i = 0; i < (10 - text.length()); i++ ) {
				returnString += " ";
			}
			return returnString;
		}
	}


	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "\"" + text + "\"";
	}

}
