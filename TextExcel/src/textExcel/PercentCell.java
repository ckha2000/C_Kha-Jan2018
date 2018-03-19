package textExcel;

public class PercentCell extends ValueCell {

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
			return truncatedValue.substring(0, 9) + "%";
		}else {
			for(int i = 0; i < 9 - truncatedValue.length(); i++) {
				truncatedValue += " ";
			}
			return truncatedValue + "%";
		}
	}
	
	public String fullCellText() {
		return "" + getDoubleValue()/100;
	}

}
