//Christopher Kha	Period 2
// 3/16/18
// EmptyCell class

package textExcel;

public class EmptyCell implements Cell {
	
	//constructor for EmptyCell
	public EmptyCell() {
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	//always returns 10 spaces
	public String abbreviatedCellText() {
		return "          ";
	}

	// text for individual cell inspection, not truncated or padded
	//always returns an empty string
	public String fullCellText() {
		return "";
	}

}
