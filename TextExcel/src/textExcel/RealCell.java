package textExcel;

public class RealCell implements Cell {
	private String inputValue;
	
	public RealCell(String inputValue) {
		this.inputValue = inputValue;
	}
	
	public String getInputValue() {
		return inputValue;
	}
	
	public double getDoubleValue() {
		return 0.0;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return ""+ getDoubleValue();
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return inputValue;
	}

}
