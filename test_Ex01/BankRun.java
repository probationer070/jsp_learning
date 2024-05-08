package test_Ex01;

public class BankRun {
	public static void main(String[] args) {
		Account myact1 = new Account("Kimddolddol", "1234-123434", 10000);
		Account myact2 = new Account("Leeyeyppun", "6754-125494", 10000);
		
		System.out.println("Kimddolddol의 계좌 :"+myact1.check_remain());
		System.out.println("계좌 잔액 : "+myact1.deposite(5000));
		try {
			System.out.println("계좌 잔액 : "+myact1.withdraw(2000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("------------------------------");
		
		System.out.println("Leeyeyppun의 계좌 :"+myact2.check_remain());
		System.out.println("계좌 잔액 : "+myact2.deposite(5000));
		try {
			System.out.println("계좌 잔액 : "+myact2.withdraw(200000));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		MinusAccount taxAct = new MinusAccount("Leeyeyppun", "6754-125494", 100000);
		taxAct.setMinusCreditLine(10000000);
		try {
			System.out.println(taxAct.withdraw(300000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
	}
}
