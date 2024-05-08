package ch09.sec02.exam03;

public class Button {
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.OnClick();
	}
	
	static interface OnClickListener {
		void OnClick();
	}
}
