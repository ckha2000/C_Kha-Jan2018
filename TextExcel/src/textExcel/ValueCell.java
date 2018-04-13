//Christopher Kha	Period 2
// 3/16/18
// ValueCell class - stores number values
package textExcel;

public class ValueCell extends RealCell {
	
	// constructor for ValueCell
	public ValueCell(String inputValue) {
		super(inputValue);
	}
	
	// returns the double value of the assignment string
	public double getDoubleValue() {
		return Double.parseDouble(super.fullCellText());
	}
}
