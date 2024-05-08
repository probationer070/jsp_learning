package ch11.sec01.exam04;

public class MemberEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member obj1 = new Member("Test");
		Member obj2 = new Member("Test");
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}
	}

}
