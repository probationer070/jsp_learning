package ch17_12.sec01;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Reduce1Demo {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(3, 4, 5, 1, 2);
    int sum1 = numbers.stream().reduce(0, (a,b) -> a+b);
    int sum2 = numbers.stream().reduce(0, Integer::sum);
    int mul1 = numbers.stream().reduce(0, (a,b) -> a*b);
    System.out.println(sum1);
    System.out.println(sum2);
    System.out.println(mul1);

    Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);
    System.out.println(sum3.get());

    OptionalInt sum4 = numbers.stream().mapToInt(x->x.intValue()).reduce(Integer::sum);
    System.out.println(sum4.getAsInt());
    
    Optional<Integer> mul2 = numbers.stream().reduce((a,b) -> a*b);
    mul2.ifPresent((Util::print));
  }
}
