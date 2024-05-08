package ch17_12.sec01;

import java.util.stream.IntStream;

public class ParalleDemo {
  public static void main(String[] args) {
    long start, end, total;

    IntStream sq = IntStream.rangeClosed(1, 100000000);
    start = System.nanoTime();
    total = sq.sum();
    end = System.nanoTime();

    System.out.println("순차처리: "+(end-start));
    
    IntStream pr = IntStream.rangeClosed(1, 100000000).parallel();

    start = System.nanoTime();
    total = pr.sum();
    end = System.nanoTime();

    System.out.println("병렬처리: "+(end-start));
  }
}
