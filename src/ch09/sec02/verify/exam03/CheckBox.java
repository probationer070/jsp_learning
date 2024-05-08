package ch09.sec02.verify.exam03;

public class CheckBox {
	OnSelectListener listener;
	
	void setOnSelectListener(OnSelectListener listener) {
		this.listener = listener;
	}
	
	void select() {
		listener.OnSelect();
	}
	
	static interface OnSelectListener {
		void OnSelect();
	}
}
