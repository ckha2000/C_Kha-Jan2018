package textExcel;

public class FormulaCell extends RealCell {
	
	public FormulaCell(String inputValue) {
		super(inputValue);
	}
	
	public double getDoubleValue() {
		String tempInput = getInputValue().substring(1, getInputValue().length()-1).trim();
		
		String[] splitInput = tempInput.split(" ");
		
		if(Character.isDigit(splitInput[0].indexOf(0))) {
			double answer = Double.parseDouble(splitInput[0]);
		}else { 	//the value is a cell
			
		}
		
		
		
		for(int i = 1; i < splitInput.length; i += 2) {
			double nextOperand = Double.parseDouble(splitInput[i+1]);
			
			if(splitInput[i].equals("+")){
				answer += nextOperand;
			}else if(splitInput[i].equals("-")) {
	         	answer -= nextOperand;
	        }else if(splitInput[i].equals("*")){
	        	answer *= nextOperand;
	        }else if(splitInput[i].equals("/")) {
	        	answer /= nextOperand;
	        }
		}
		
		return answer;
	}
	
}
