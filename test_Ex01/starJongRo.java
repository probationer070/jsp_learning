package test_Ex01;

public class starJongRo implements Starbucks, Pastry{

	@Override
	public void americano() {
		// TODO Auto-generated method stub
		System.out.println("종료 비싼 물가를 느끼며 아메리카노");
	}

	@Override
	public void latte() {
		// TODO Auto-generated method stub
		System.out.println("종로 라떼?");
	}

	@Override
	public void cappuccino() {
		// TODO Auto-generated method stub
		System.out.println("종로 카푸치노");
	}
	
	@Override
	public void Tramisoo() {
		System.out.println("티라미수");
	}
	@Override
	public void cake() {
		System.out.println("생크림 케익");
	}

}
