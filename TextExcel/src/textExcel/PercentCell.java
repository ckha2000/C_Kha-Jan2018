package textExcel;

public class PercentCell extends RealCell{

	public PercentCell(String inputValue) {
		super(inputValue);
	}
	
	public double getDoubleValue() {
		String tempString = getInputValue().replaceAll("%", "");
		return Double.parseDouble(tempString);
	}
	
	public String abbreviatedCellText() {
		String truncatedValue = "" + (int) getDoubleValue();
		if(truncatedValue.length() > 10) {
			return truncatedValue.substring(0, 10);
		}else {
			truncatedValue += "%";
			int tempLength = truncatedValue.length();
			
			for(int i = 0; i < 10 - tempLength; i++) {
				truncatedValue += " ";
			}
			return truncatedValue;
		}
	}
	
	public String fullCellText() {
		return "" + getDoubleValue()/100;
	}

}
