package textExcel;

public class RealCell implements Cell {
	private String inputValue;
	
	public RealCell(String inputValue) {
		this.inputValue = inputValue;
	}
	
	public double getDoubleValue() {
		return 0.0;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return null;
	}

}
