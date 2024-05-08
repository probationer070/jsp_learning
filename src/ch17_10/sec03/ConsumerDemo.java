package ch17_10.sec03;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerDemo {
  public static void main(String[] args) {
    // Consumer c = new Consumer<String>() {
    //   public void accept(String t) {
    //     System.out.println(t.toLowerCase());
    //   }
    // };

    Consumer<String> c1 = x -> System.out.println(x.toLowerCase());
    c1.accept("JAVA Functional Interface");

    BiConsumer<String, String> c2 = (x, y) -> System.out.println(x + " : " + y);
    c2.accept("JAVa", "Lamda");

    ObjIntConsumer<String> c3 = (s, i) -> {
      int a = Integer.parseInt(s)+i;
      System.out.println(a);
    };
    c3.accept("100", 50);

    IntConsumer c4 = x -> System.out.printf("%d * %d = %d\n", x, x, x * x);
    IntConsumer c5 =  c4.andThen(x -> System.out.printf("%d + 10 = %d", x, x+10));
    c5.accept(10);
  }
}
