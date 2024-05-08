package ch08.sec01.exam05;

import ch08.sec01.exam03.RemoteControl;

public class SmartTelevision implements RemoteControl, Searchable {
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV On");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV Off");
	}
	
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("Current Volume : "+this.volume);
	}
	
	@Override
	public void search(String url) {
		System.out.println(url+" Searching ...");
	}
}
