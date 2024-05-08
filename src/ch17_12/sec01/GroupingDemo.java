package ch17_12.sec01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingDemo {
  public static void main(String[] args) {
    Stream<Nation> sn = Nation.nations.stream().limit(4);
    Map<Nation.Type, List<Nation>> m1 = sn.collect(Collectors.groupingBy(Nation::getType));
    System.out.println(m1);
  }
}
