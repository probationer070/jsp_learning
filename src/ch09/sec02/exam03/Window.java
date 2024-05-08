package ch09.sec02.exam03;

public class Window {
	Button button1 = new Button();
	Button button2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		@Override
		public void OnClick() {
			System.out.println("Call");
		}
	};
	
	Window() {
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void OnClick() {
				System.out.println("Send MSG");
			}
		});
	}
}
