package ch07.sec02.exam03;

public class MsgSendDemo {
	public static void main(String[] args) {
		MsgSend m[] = {new SmsSend(), new EmailSend()};
		
//		1)
		MsgSend m11 = m[0];
		MsgSend m12 = m[1];
		m11.send();
		m12.send();
		
//		2)
		for(int i=0; i<m.length; i++) {
			m[i].send();
		}
		
//		3)
		for (MsgSend m1 : m) {
			m1.send();
		}
	}
}
