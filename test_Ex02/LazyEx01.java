package test_Ex02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEx01 {

  private static int counter;

  public static void main(String[] args) {

    List<String> list = Arrays.asList("Eric", "Elena", "Java");
    
    counter = 0;
    Stream<String> stream = list.stream()
      .filter(el -> {
        wasCalled();
        return el.contains("a");
      });
    System.out.println(counter); // 0 ??
  }

  private static void wasCalled() {
    counter++;
  }
}