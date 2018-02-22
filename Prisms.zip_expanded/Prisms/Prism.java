//Christopher Kha
//Period 2
// 2/22/18

/* Write this abstract class called Prism.  It has one private field (height) and a constructor.  
 * It contains the methods calcAreaOfBase, calcPerimeter, calcVolume, and calcSA.
 * None of these methods require parameters.   
 * A couple are abstract - can you tell which ones and why?
 * 
 * Math note:
 * The volume of any prism can be found by multiplying the area of the base by the height.
 * The surface area of any prism can be found by multiplying the perimeter of the base by the height
 *   and then adding on the areas of the 2 bases.
 */


public abstract class Prism  
{
	private double height;
	
	public Prism(double height){
		this.height = height;
	}
	
	public abstract double calcAreaOfBase();
	public abstract double calcPerimeter();
	
	public double calcVolume(){
		return round(calcAreaOfBase()*height);
	}
	
	public double calcSA(){
		return round(calcAreaOfBase()*2 + calcPerimeter()*height);
	}
	
	public static double round(double orig){
		double result = 0.0;
		
		int tempInt = (int) (orig * 1000);
		
		int roundNum = tempInt % 10;	//takes the digit in the 3rd decimal place of the original number
		tempInt = tempInt/10;				
		if(roundNum >=5 && tempInt > 0) { //positive
			tempInt++;
		}
		result = tempInt/100.0;
		return result;
	}
}
	