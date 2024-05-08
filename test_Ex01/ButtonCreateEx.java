package test_Ex01;

public class ButtonCreateEx {
	public static void main(String[] args) {
		Button b[] = new Button[2];
		
		Button b1 = new Button() {
			@Override
			public void click() {
				// TODO Auto-generated method stub
				System.out.println("TURN ON");
			}
		};
		
		Button b2 = new Button() {
			@Override
			public void click() {
				// TODO Auto-generated method stub
				System.out.println("마우스로 선택");
			}
		};
		
//		b1.click();
//		b2.click();
		b[0] = b1;
		b[1] = b2;
		
		for (int i=0; i<b.length; i++) {
			b[i].click();
		}
	}
}
