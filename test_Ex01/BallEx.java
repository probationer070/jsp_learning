package test_Ex01;

public class BallEx {
	public static void main(String[] args) {
		Ball friendBall = new Ball();
		Ball myBall = new Ball();
		
		myBall.radius = 5.0;
		
		double friendBVol = friendBall.getVolume();
		System.out.println(friendBVol);
	}
	
}
