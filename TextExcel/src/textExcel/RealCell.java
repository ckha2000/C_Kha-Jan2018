//Christopher Kha	Period 2
// 3/16/18
// RealCell - number values including percents and formulas
package textExcel;

public class RealCell implements Cell { 		
	//stores the text input by the user so it can be used in subclasses
	private String inputValue;
	
	//constructor for RealCell
	public RealCell(String inputValue) {
		this.inputValue = inputValue;
	}
	
	//override this in subclasses
	public double getDoubleValue() {
		return 0.0;
	}
	
	//returns the double value - pads and truncates as necessary
	public String abbreviatedCellText() {
		String returnString = "" + getDoubleValue();
		if(returnString.length() > 10) {
			return returnString.substring(0, 10);
		}else {
			int tempLength = returnString.length();
			for(int i = 0; i < 10 - tempLength; i++) {
				returnString += " ";
			}
			return returnString;
		}
	}

	//returns the input value - can be used in subclass code to access inputValue
	public String fullCellText() {
		return inputValue;
	}

}
