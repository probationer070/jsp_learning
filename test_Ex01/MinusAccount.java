package test_Ex01;

public class MinusAccount extends Account{
	private int MinusCreditLine;
	
	public MinusAccount(String owner, String AccNumber, long remain) {
		super(owner, AccNumber, remain);
	}
	
	public int getMinusCreditLine() {
		return MinusCreditLine;
	}
	
	public void setMinusCreditLine(int MinusCreditLine) {
		this.MinusCreditLine = MinusCreditLine;
	}
	
	@Override
	public long withdraw(long num) throws Exception {
		if (MinusCreditLine + check_remain() >= num) {
			remain -= num;
			return num;
		} else {
			throw new Exception("한도초과");
		}
	}
}
