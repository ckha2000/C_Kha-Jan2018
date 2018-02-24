//Christopher Kha
//Period 2
// 2/23/18

public abstract class ThreeDShape {
	private double volume;
	private double surfaceArea;

	public ThreeDShape(){
		this.volume = calcVolume();
		this.surfaceArea = calcSA();
	}

	public abstract double calcVolume();
	public abstract double calcSA();
}