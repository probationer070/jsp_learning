package ch07.sec01.exam01;

public class DmbCellphoneEx {
	public static void main(String[] args) {
		DmbCellphone myPhone = new DmbCellphone("Galaxy", "Black", 0);
		
		System.out.println(myPhone.model);
		System.out.println(myPhone.color);
		
		System.out.println(myPhone.channel);
		
		myPhone.powerOn();
		myPhone.bell();
		myPhone.sendVoice("Hello, Jon");
		myPhone.receiveVoice("Hello, Bob");
		myPhone.sendVoice("How are you?");
		myPhone.hangUp();
		
		myPhone.turnDmb();
		myPhone.changChannelDnb(8000);
		myPhone.turnOffDmb();
	}
}
