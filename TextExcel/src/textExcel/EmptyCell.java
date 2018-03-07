package textExcel;

public class EmptyCell implements Cell {
	private String fullText;
	
	public EmptyCell() {
	}
	
	@Override
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return fullText.substring(0, 9);
	}

	@Override
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		// TODO Auto-generated method stub
		return fullText;
	}

}
