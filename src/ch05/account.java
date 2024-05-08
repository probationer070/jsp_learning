package ch05;

public class account {

	String account;
	String admin;
	long remain;
	
	long asset_search() {
		return remain;
	}
	
	void insert(int price) {
		remain += price;
	}
	
	long expend(int price) {
		remain -= price;
		return price;
	}
}

