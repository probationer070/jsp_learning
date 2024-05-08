package ch08.sec01.exam05;

import ch08.sec01.exam03.RemoteControl;

public class SmartTelevisionExample {
	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		
		RemoteControl rc = tv;
		Searchable searchable = tv;
		
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(3);
		
		searchable.search("http://www.google.com");
		
		
		tv.search(null);
		tv.setVolume(0);
	}
}
