package test_Ex01;

public class starHeisu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Starbucks star[] = {new starJeju(), 
							new starJongRo(), 
							new starSungNam()};
		
		for (Starbucks chain: star) {
			System.out.println("=================");
			chain.americano();
			chain.cappuccino();
			chain.latte();
			
			System.out.println("=================");
		}
		
		if(star[1] instanceof starJongRo) {
			Pastry cake = (Pastry) star[1];
			cake.cake();
			cake.Tramisoo();
		}
		
	}

}
