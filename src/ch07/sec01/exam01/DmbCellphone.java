package ch07.sec01.exam01;

public class DmbCellphone extends Cellphone {
	int channel;
	
	DmbCellphone(String model, String color, int channel) {
//		this.model = model;
//		this.color = color;
		super(model, color);
		this.channel = channel;	
	}
	
	void turnDmb() {
		System.out.println("채널 "+channel+"번 DMB 방송 수신을 시작");
	}
	
	void changChannelDnb(int channel) {
		System.out.println("채널 "+channel+"번으로 변경");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 채널을 종료");
	}
}
