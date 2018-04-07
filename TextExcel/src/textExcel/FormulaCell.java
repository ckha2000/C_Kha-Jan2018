package textExcel;

public class FormulaCell extends RealCell {
	private Spreadsheet grid;
	
	public FormulaCell(String inputValue, Spreadsheet sheet) {
		super(inputValue);
		grid = sheet;
	}

	public double computeFormula(String range, boolean isAverage) {

		String[] splitRange = range.split("-");
		int r1 = Integer.parseInt(splitRange[0].substring(1));
		int r2 = Integer.parseInt(splitRange[1].substring(1));

		char c1 = Character.toUpperCase(splitRange[0].charAt(0));
		char c2 = Character.toUpperCase(splitRange[1].charAt(0));

		double sum = 0.0;
		int numValues = 0;

		for(int r = r1; r <= r2; r++) {
			for(char c = c1; c <= c2; c++) {
				Location loc = new SpreadsheetLocation("" + c + r);
				
				if(grid.getCell(loc) instanceof RealCell) {
					RealCell tempCell = ((RealCell) (grid.getCell(loc)));
					sum += tempCell.getDoubleValue();
					numValues++;
				}
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
		double answer = 0.0;
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
			if(grid.getCell(loc) instanceof RealCell) {
				RealCell tempCell = ((RealCell) grid.getCell(loc));
				answer = tempCell.getDoubleValue();
			}
		}

		for(int i = 1; i < splitInput.length; i += 2) {
			double nextOperand;

			if(Character.isDigit(splitInput[i+1].charAt(0)) || splitInput[i+1].charAt(0) == '-') {
				nextOperand = Double.parseDouble(splitInput[i+1]);
			}else {
				loc = new SpreadsheetLocation(splitInput[i+1]);
				if(grid.getCell(loc) instanceof RealCell) {
					RealCell tempCell = ((RealCell) grid.getCell(loc));
					nextOperand = tempCell.getDoubleValue();
				}else {
					nextOperand = 0;
				}
				
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
