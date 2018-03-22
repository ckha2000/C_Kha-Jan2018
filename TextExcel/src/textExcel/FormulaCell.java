package textExcel;

public class FormulaCell extends RealCell {
	
	public FormulaCell(String inputValue) {
		super(inputValue);
	}
	
	public double getDoubleValue() {
		/*String[] splitInput = getInputValue().split(" ");
		
		double answer;
		
		for(int i = 1; i < splitInput.length; i += 2) {
			if(splitInput[i].equals("+") || splitInput[i].equals("-")) {
	         	if()
	        }else if(splitInput[i].equals("*") || splitInput[i].equals("/")) {
	         	temp = op1.multiplication(op2, operator);
	        }
		}
		*/
		return 0.0;
	}
	
}
