//Christopher Kha	Period 2
// 3/16/18
// Value Cell class
package textExcel;

public class ValueCell extends RealCell {
	private double value;
	
	public ValueCell(String inputValue) {
		super(inputValue);
		value = getDoubleValue();
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(super.getInputValue());
	}
	
	public String abbreviatedCellText() {
		if(this.fullCellText().length() > 10) {
			return this.fullCellText().substring(0, 10);
		}else {
			String returnString = this.fullCellText();
			for(int i = 0; i < 10 - returnString.length(); i++) {
				returnString += " ";
			}
			return returnString;
		}
	}
	
	public String fullCellText() {
		return "" + value;
	}
}
