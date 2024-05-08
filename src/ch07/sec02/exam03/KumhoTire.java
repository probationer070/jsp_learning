package ch07.sec02.exam03;

public class KumhoTire extends Tire {
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location+"KumhoTire Remain : "+(maxRotation-accumulatedRotation));
			return true;
		}else {
			System.out.println("***"+location+"KumhoTire FUNK !***");
			return false;
		}
	}
}
