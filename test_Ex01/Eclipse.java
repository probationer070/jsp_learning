package test_Ex01;

public class Eclipse extends Circle {
	public double lrad;
	public double srad;
	final double pi = Math.PI;
	
	public Eclipse() {}
	
	public Eclipse(double lrad, double srad) {
		this.lrad = lrad;
		this.srad = srad;
	}
	
	public double Circle_area() {
		return lrad * srad * pi;
	}
}
