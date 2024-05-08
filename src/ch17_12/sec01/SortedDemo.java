package ch17_12.sec01;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortedDemo {
  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("d12", "a2", "b1", "b3", "c");
    Stream<String> s2 = s1.sorted();
    s2.forEach(Util::print);

    System.out.print("\n 국가 이름 순서 : ");
    Stream<Nation> n1 =Nation.nations.stream();
    // 국가이름별 정렬(알파벳 오름차순)
    Stream<Nation> n2 = n1.sorted(Comparator.comparing(Nation::getName));
    // 정렬한 스트림에서 국가명만 가져오기
    Stream<String> s3 = n2.map(x -> x.getName());
    s3.forEach(Util::printParenthesis);
    System.out.println();


    System.out.print("\n 국가 GDP 순서 : ");
    Stream<Nation> n3 =Nation.nations.stream();
    Stream<Nation> n4 = n3.sorted(Comparator.comparing(Nation::getGdpRank));
    Stream<Object> s4 = n4.map(x -> x.getGdpRank());
    s4.forEach(Util::printParenthesis);
    System.out.println();

    System.out.print("\n 국가 인구 순서 : ");
    Stream<Nation> n5 =Nation.nations.stream();
    Stream<Nation> n6 = n5.sorted(Comparator.comparing(Nation::getPopulation));
    Stream<Object> s5 = n6.map(x -> x.getPopulation());
    s5.forEach(Util::printParenthesis);
    
  }
}
