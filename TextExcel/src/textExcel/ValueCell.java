//Christopher Kha	Period 2
// 3/16/18
// Value Cell class
package textExcel;

public class ValueCell extends RealCell {
	private double value;
	
	public ValueCell(String inputValue) {
		super(inputValue);
		value = Double.parseDouble(super.getInputValue());
	}
	
	public double getDoubleValue() {
		return value;
	}
}
