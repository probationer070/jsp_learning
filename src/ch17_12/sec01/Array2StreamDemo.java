package ch17_12.sec01;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Array2StreamDemo {
  public static void main(String[] args) {
    int[] ia = {2, 3, 5, 7, 11, 13};
    IntStream is = Arrays.stream(ia);
    is.forEach(x -> System.out.print(x + " "));
    System.out.println();

    String[] strings = {"The", "pen", "is", "mighter", "then", "the", "sword"};
    Stream<String> ss = Stream.of(strings);
    ss.sorted().forEach(x -> System.out.print(x + " "));
    System.out.println();

    double[] da = { 1.2, 3.14, 3.8, 0.2};
    DoubleStream ds = DoubleStream.of(da);
    ds.forEach(x -> System.out.print(x + " "));
  }
}
