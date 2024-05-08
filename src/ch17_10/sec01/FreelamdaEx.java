package ch17_10.sec01;

class A implements Negative {
  @Override
  public int neg(int x) {
    return -x;
  }
}

public class FreelamdaEx {
  public static void main(String[] args) {
    Negative n = new A();
    int b = n.neg(5);
    System.out.println(b);
  }
}