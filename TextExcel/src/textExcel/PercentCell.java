//Christopher Kha	Period 2
// 3/16/18
// PercentCell - characterized by % sign at the end of a number

package textExcel;

public class PercentCell extends RealCell{

	//constructor for PercentCell 
	public PercentCell(String inputValue) {
		super(inputValue);
	}
	
	//stores just the percent value without the percent sign
	public double getDoubleValue() {
		String tempString = super.fullCellText().replaceAll("%", "");
		return Double.parseDouble(tempString);
	}
	
	//returns the percent value with the % sign - pads and truncates as needed
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
	
	//returns the value is a decimal
	public String fullCellText() {
		return "" + getDoubleValue()/100;
	}

}
