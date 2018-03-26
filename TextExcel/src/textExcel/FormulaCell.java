package textExcel;

public class FormulaCell extends RealCell {
	
	public FormulaCell(String inputValue) {
		super(inputValue);
	}
	
	public double getDoubleValue() {
		String tempInput = getInputValue().substring(1, getInputValue().length()-1).trim();
		
		String[] splitInput = tempInput.split(" ");
		double answer;
		Location loc;
		
		if(Character.isDigit(splitInput[0].indexOf(0))) {
			answer = Double.parseDouble(splitInput[0]);
		}else if(Character.isDigit(splitInput[0].indexOf(1))) { 	//the value is a cell or a formula
			loc = new SpreadsheetLocation(splitInput[0]);
			answer = ((RealCell)TextExcel.userSheet.getCell(loc)).getDoubleValue();
		}else {
			answer = 0.0;
		}
		
		System.out.println(answer);
		
		for(int i = 1; i < splitInput.length; i += 2) {
			double nextOperand;
			
			if(Character.isDigit(splitInput[i+1].indexOf(0))) {
				nextOperand = Double.parseDouble(splitInput[i+1]);
			}else {
				loc = new SpreadsheetLocation(splitInput[i+1]);
				nextOperand = ((RealCell)TextExcel.userSheet.getCell(loc)).getDoubleValue();
			}
			
			
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
