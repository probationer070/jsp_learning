package ch17_10.sec01;

interface Mathematical {
  double calculate(double d);
}

interface Pickable {
  char pick(String s, int i);
}

interface Computable {
  int add(int a, int b);
}

class Utils {
  int add(int a, int b) {
    return a + b;
  }
}

public class MethodRef1Demo {
  public static void main(String[] args) {
    Mathematical m;
    Pickable p;
    Computable c;

    // m = d -> Math.abs(d);
    m = Math::abs;
    System.out.println(m.calculate(-50.33));

    // Pickable p2 =new Pickable() {
    //   @Override
    //   public char pick(String s, int i) {
    //     return s.charAt(i);
    //   }
    // };

    // p = (s,b) -> s.charAt(b); // 위에 공식과 같은 방식 
    p = String :: charAt;   // 위에 공식과 같은 방식 
    System.out.println(p.pick("안녕 인스턴스 메소드 참조", 4));

    /*
     interface Computable을 구현하고 해당 메소드에서 이미 만들어진 클래스 Util의 메소드를 사용하려는 경우
     */
    Utils u = new Utils();

    // Computable c1 = new Computable() { // 익명 클래스
    //   @Override
    //   public int add(int a, int b) {
    //     return u.add(a, b);
    //   }
    // };

    // Lamda
    // c = (x, y) -> u.add(x, y);
    c = u :: add;
    System.out.println(c.add(5, 2));

  }
}
