package ch09.sec01.exam06;

public class CallListener implements Button.OnClickListener {
	@Override
	public void onClick() {
		System.out.println("메세지를 보냅니다.");
	}
}
