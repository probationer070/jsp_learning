package ch17_12.sec01;

import java.util.stream.IntStream;

public class Laziness2Demo1 {
  public static void main(String[] args) {
    IntStream is = IntStream.rangeClosed(1, 20);
    is.filter(x-> {     // 느긋한 연산 1
      System.out.println("filter : "+x);
      return x%5 == 0;
    }).map(x -> {   // 느긋한 연산 2
      System.out.println("map : "+x);
      if (x%2 == 0)
       return x;
      return 0;
    }).forEach(x -> System.out.println("forEach : "+x));  // 조급한 연산, 결과 바로 실행
  }
}
