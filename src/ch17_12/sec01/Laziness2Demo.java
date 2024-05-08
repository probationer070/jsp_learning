package ch17_12.sec01;

import java.util.stream.IntStream;

public class Laziness2Demo {
  public static void main(String[] args) {
    IntStream is = IntStream.rangeClosed(1, 5);
    is.filter(x-> {     // 느긋한 연산 1
      System.out.println("filter : "+x);
      return x%2 == 0;
    }).map(x -> {   // 느긋한 연산 2
      System.out.println("map : "+x);
      return x*x;
    }).forEach(x -> System.out.println("forEach : "+x));  // 조급한 연산, 결과 바로 실행
  }
}
