package ch17_12.sec01;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect2Demo {
  public static void main(String[] args) {
    Stream<Nation> sn = Nation.nations.stream();
    Double avgs = sn.collect(Collectors.averagingDouble(Nation::getPopulation));
    System.out.println("국가들 인구 평균 : "+avgs);
    
    sn = Nation.nations.stream();
    long num =  sn.collect(Collectors.counting());
    System.out.println("국가 수 : "+num);
    
    sn = Nation.nations.stream();
    String cons = sn.limit(4).map(Nation::getName).collect(Collectors.joining("=="));
    System.out.println("앞에 4개 나라 : "+cons);

    sn = Nation.nations.stream();
    Optional<Double> max = sn.map(Nation::getPopulation).collect(Collectors.maxBy(Double::compare));
    System.out.println("나라의 최대 인구수 : "+max);

    sn = Nation.nations.stream();
    Set<Nation> hashSet = sn.filter(Predicate.not(Nation::isIsland))
                    .collect(Collectors.toCollection(HashSet<Nation>::new));

    hashSet.forEach(x -> Util.print("("+ x.getName() + ", " + x.getGdpRank() + ")"));
  }
}
