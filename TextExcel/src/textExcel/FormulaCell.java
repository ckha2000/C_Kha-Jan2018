package textExcel;

public class FormulaCell extends RealCell {
	private Spreadsheet grid;
	
	public FormulaCell(String inputValue) {
		super(inputValue);
		grid = TextExcel.userSheet;
	}
	
	public double computeFormula(String range, boolean isAverage) {
		
		String[] splitRange = range.split("-");
		int r1 = Integer.parseInt(splitRange[0].substring(1));
		int r2 = Integer.parseInt(splitRange[1].substring(1));
		
		char c1 = splitRange[0].charAt(0);
		char c2 = splitRange[1].charAt(0);
		
		double sum = 0.0;
		int numValues = 0;
		
		for(int r = r1; r <= r2; r++) {
			for(char c = c1; c <= c2; c++) {
				Location loc = new SpreadsheetLocation("" + c + r);
				sum += ((RealCell) (grid.getCell(loc))).getDoubleValue();
				numValues++;
			}
		}
		
		if(isAverage) {
			return sum/numValues;
		}else {
			return sum;
		}
	}
	
	public double getDoubleValue() {
		String tempInput = getInputValue().substring(1, getInputValue().length()-1).trim();
		
		String[] splitInput = tempInput.split(" ");
		double answer;
		Location loc;
		
		if(splitInput[0].equalsIgnoreCase("sum")) {
			return computeFormula(splitInput[1], false);
		}else if(splitInput[0].equalsIgnoreCase("avg")) {
			return computeFormula(splitInput[1], true);
		}
		
 		if(Character.isDigit(splitInput[0].charAt(0)) || splitInput[0].charAt(0) == '-') { // its a number
			answer = Double.parseDouble(splitInput[0]);
		}else {
			loc = new SpreadsheetLocation(splitInput[0]);
			answer = ((RealCell) (grid.getCell(loc))).getDoubleValue();
		}
		
		for(int i = 1; i < splitInput.length; i += 2) {
			double nextOperand;
			
			if(Character.isDigit(splitInput[i+1].charAt(0)) || splitInput[i+1].charAt(0) == '-') {
				nextOperand = Double.parseDouble(splitInput[i+1]);
			}else {
				loc = new SpreadsheetLocation(splitInput[i+1]);
				Cell tempCell = grid.getCell(loc);
				nextOperand = ((RealCell) tempCell).getDoubleValue();
			
			
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
		}
		return answer;
	}
}
