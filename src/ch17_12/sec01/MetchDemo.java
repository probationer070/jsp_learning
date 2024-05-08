package ch17_12.sec01;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MetchDemo {
  public static void main(String[] args) {
    // 하나라도 조건에 성립하면 true
    boolean b1 = Stream.of("a1", "b2", "c3").anyMatch(s->s.startsWith("c"));  
    System.out.println(b1); 
    
    // 모두 조건에 성립해야만 true 반환
    boolean b2 = IntStream.of(10, 20, 30).allMatch(x->x%2==0);  
    System.out.println(b2);

    // 함수 결과에 맞는 것이 없을 때 true
    boolean b3 = IntStream.of(1,2,3).noneMatch(p->p==4);
    System.out.println(b3);

    if(Nation.nations.stream().allMatch(p->p.getPopulation()>100.0))
      System.out.println("모든 국가는 인구가 1억이 넘는다");
    else
      System.out.println("모든 국가는 인구가 1억이 넘지 않는다");
    
    Optional<Nation> n = Nation.nations.stream().findFirst();
    n.ifPresentOrElse(Util::print, () -> System.out.println("None"));
    System.out.println();
    n = Nation.nations.stream().filter(Nation::isIsland).findAny();
    n.ifPresent(Util::print);
  } 
}
