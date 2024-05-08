package ch07.sec01.exam01;

public class Cellphone {
	String model;
	String color;
	
//	Cellphone(){}
	Cellphone(String model, String color){
		this.model = model;
		this.color = color;		
	}
	
	void powerOn() {System.out.println("POWER ON");}
	void powerOff() {System.out.println("POWER OFF");}
	void bell() {System.out.println("알람이 울립니다.");}
	void sendVoice(String message) {System.out.println("자신 : "+message);}
	void receiveVoice(String message) {System.out.println("상대방 : "+message);}
	void hangUp() {System.out.println("전화를 끊는다");}
}
