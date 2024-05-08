package test_Ex01;

public class Account {
	private String owner;
	private String AccNumber;
	protected long remain;
	
	public Account() {}
	
	public Account(String owner, String AccNumber) {
		this.owner = owner;
		this.AccNumber = AccNumber;
	}
	public Account(String owner, String AccNumber, long remain) {
		this.owner = owner;
		this.AccNumber = AccNumber;
		this.remain = remain;
	}
	
	public long check_remain() {
		return remain;
	}
	
	public long deposite(long num) {
		remain += num;
		return remain;
	}
	
	public long withdraw(long num) throws Exception {
		if (remain >= num) {
			remain -= num;
			return getRemain();
		} else {
			throw new Exception("잔액부족");
		}
	}

	public long getRemain() {
		return remain;
	}

	public void setRemain(long remain) {
		this.remain = remain;
	}

}
