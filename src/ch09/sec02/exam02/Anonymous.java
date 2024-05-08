package ch09.sec02.exam02;

public class Anonymous {
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			// TODO Auto-generated method stub
			System.out.println("TV on");
		}
		
		@Override
		public void turnOff() {
			// TODO Auto-generated method stub
			System.out.println("TV off");
		}
	};
	
	void method1() {
		RemoteControl localVar = new RemoteControl() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("Audio on");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("Audio off");
			}
		};
		localVar.turnOn();
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}
