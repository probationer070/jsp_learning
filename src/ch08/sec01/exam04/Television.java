package ch08.sec01.exam04;

public class Television implements RemoteControl{
	private int volume;
	
	public void turnOn() {
		System.out.println("TV on");
	}
	
	public void turnOff() {
		System.out.println("TV off");
	}
	
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("Current TV Vol : "+this.volume);
	}
}
