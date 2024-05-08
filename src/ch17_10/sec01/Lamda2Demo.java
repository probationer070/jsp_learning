package ch17_10.sec01;

interface Negative {
  int neg(int x);
}

interface Printable {
  void print();
}

public class Lamda2Demo {
  public static void main(String[] args) {
    Negative n;
    // 구현체의 메서드만 정의
    n = (int x) -> {return -x;};
    // 매개변수 타입 생략
    n = (x) -> {return -x;};
    // 매개변수 타입 생략 + 괄호 생략
    n = x -> {return -x;};

    // return 없어도 된다.
    n = (int x) -> -x;  // 메소드 이므로 return을 컴파일러가 알게 된다.
    n = x -> -x;
    System.out.println(n.neg(3));

    Printable p;
    p = () -> {System.out.println("hello");};
    p = () -> System.out.println("hello");
    p.print();
  }
  
}
