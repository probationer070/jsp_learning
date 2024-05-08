package ch17_10.sec03;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateDemo {
  public static void main(String[] args) {
    // IntPredicate even1 = new IntPredicate() {
    //   public boolean test(int value) {
    //     return value%2==0;
    //   }
    // };

    IntPredicate even = x -> x%2==0;    // 구현객체
    System.out.println("IntPredicate.test ==> "+(even.test(3) ? "짝수" : "홀수"));

    IntPredicate one = x -> x==1;
    IntPredicate oneOrEven = one.or(even);  // 디폴트 메소드
    System.out.println("oneOrEven.or ==> "+ (oneOrEven.test(1) ? " 1혹은 짝수" : " 1이 아닌 홀수"));

    // Predicate<String> p1 = new Predicate<String>() {
    //   public boolean test(String t) {
    //     return this.equals("Java lambda");
    //   };
    // };
      
    Predicate<String> p = Predicate.isEqual("Java Lambda");
    System.out.println("Predicate.isEqual ==> "+p.test("Java lambda"));
    System.out.println("Predicate.isEqual ==> "+p.test("JavaFx"));
    
    BiPredicate<Integer, Integer> bp = (x,y) -> x>y;
    System.out.println("BiPredicate ==> "+bp.test(5, 3)); 
  }
}
