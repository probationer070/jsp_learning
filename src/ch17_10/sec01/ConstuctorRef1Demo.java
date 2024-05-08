package ch17_10.sec01;

interface NewObject<T> {
  T getObject(T o); // 추상메서드, T타입의 클래스로 리턴해주는 메소드, 매개변수도 T타입
}

interface NewArray<T> {
  T[] getArray(int size);
}

public class ConstuctorRef1Demo {
  public static void main(String[] args) {
    // NewObject<String> s1 = new NewObject() {
    //   @Override
    //   public String getObject(String o) {
    //     return o;
    //   }
    // };
    // System.out.println(s1.getObject("대구"));

    NewObject<String> s;
    s = x -> new String(x); // string 이라는 생성자를 사용하고 있음.
    s = String :: new;
    
    String str = s.getObject("사과");
    System.out.println(str);

    NewArray<Integer> i1 = new NewArray<Integer>() {
      @Override
      public Integer[] getArray(int size) {
        return new Integer[size];
      };
    };
    Integer[] aa = i1.getArray(3);
    aa[0] = 1;
    aa[1] = 2;
    aa[2] = 4;

    System.out.println(i1); // 익명 클래스의 참조값 출력
    System.out.println(aa[0]);

    NewArray<Integer> i;
    i = x -> new Integer[x];
    i = Integer[] :: new;
    Integer[] array = i.getArray(2);
    array[0] = 20;
    array[1] = 30;
    System.out.println(i);
    System.out.println(array[0]);
  }
}
