//Christopher Kha	Period 2
// 3/16/18
package textExcel;

public class RealCell implements Cell { 		// Comparable<RealCell> - Checkpoint 6
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

	public String fullCellText() {
		return inputValue;
	}

	
	//Checkpoint 6
	/*
	public int compareTo(RealCell arg0) {
		return 0;
	}
	*/
}
