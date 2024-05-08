package ch17_12.sec01;

import java.util.List;

public class ReduceDemo {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(3, 4, 5, 1, 2);
    int sum1 = numbers.stream().reduce(0, (a,b) -> a+b);
    System.out.println(sum1);
  }
}
