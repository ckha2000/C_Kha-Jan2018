package textExcel;

public class TextCell implements Cell {  		//Comparable<TextCell> - Checkpoint 6
	private String text;
	
	public TextCell(String input) {
		text = input;
	}
	
	public String getText() {
		return text;
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

	
	//Checkpoint 6 
	//returns -1 if this cell comes before, 0 if they are equal, 1 if this cell comes after
	/*public int compareTo(TextCell compCell) {
		int compLength = text.length();
		
		if(this.text.length() > compCell.getText().length()) {
			compLength = compCell.getText().length();
		}
		
		for(int i = 0; i < this.text.length(); i++) {
			if(Character.toUpperCase(this.text.charAt(i)) > Character.toUpperCase(compCell.getText().charAt(i))) {
				return -1;
			}else if(Character.toUpperCase(this.text.charAt(i)) < Character.toUpperCase(compCell.getText().charAt(i))) {
				return 1;
			}
		}
		
		if(this.text.length() < compCell.getText().length()) {
			return 
		}
		return 0;
	}
	*/
}
