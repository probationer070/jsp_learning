package test_Ex01;

public class birdsEx {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Birds jacks = new Birds() {
			
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("참새가 귀엽게 난다.");
			}
		};
		
		Birds Eagle = new Birds() {
			
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("독수리는 매우 빨리 난다.");
			}
		};
		
		Birds Crow = new Birds() {
					
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("SMART");
			}
		};
		
		jacks.fly();
		Eagle.fly();
		Crow.fly();
	}
}
