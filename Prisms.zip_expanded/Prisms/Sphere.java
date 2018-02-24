//Christopher Kha
//Period 2
// 2/23/18

public class Sphere extends ThreeDShape{
	private double radius;
	
	public Sphere(double radius){
		this.radius = radius;
	}
	
	public double calcVolume(){
		return 4.0/3 * Math.PI * radius * radius * radius;  
	}
	
	public double calcSA(){
		return 4.0 * Math.PI * radius * radius;
	}
}