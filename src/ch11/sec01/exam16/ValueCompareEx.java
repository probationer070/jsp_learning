package ch11.sec01.exam16;

public class ValueCompareEx {

	public static void main(String[] args) {
		System.out.println("[-128~127 초과값인 경우]");
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("==결과: "+ (obj1 == obj2));
		System.out.println("언박싱후 ==결과: "+ (obj1.intValue() == obj2.intValue()));
		System.out.println("equals() 결과: "+ obj1.equals(obj2));
		System.out.println();
		
		System.out.println("[-128~127 범위값인 경우]");
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("==결과: "+ (obj3 == obj4));
		System.out.println("언박싱후 ==결과: "+ (obj3.intValue() == obj4.intValue()));
		System.out.println("equals() 결과: "+ obj3.equals(obj4));
		System.out.println();
		
		Character c1 = 'B';
		Character c2= 'B';
		System.out.println("==결과: "+ (c1 == c2));
		System.out.println("언박싱후 ==결과: "+ (c1.charValue() == c2.charValue()));
		System.out.println("equals() 결과: "+ c1.equals(c2));
	}

}
