package ch17_12.sec01;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Optional1Demo {

  public static void main(String[] args) {
    OptionalInt i = OptionalInt.of(100);
    OptionalDouble d = OptionalDouble.of(3.14);
    Optional<String> s = Optional.of("apple");
    System.out.println(i.getAsInt());
    System.out.println(d.getAsDouble());
    System.out.println(s.get());

    System.out.println(divide(1.0, 2.0));
    System.out.println(divide(1.0, 0.0));
  }

  public static OptionalDouble divide(double x, double y) {
    return y==0 ? OptionalDouble.empty(): OptionalDouble.of(x/y);
  }
}