package ch17_10.sec01;

// import java.util.Comparator;

interface UseThis {
  void use();
}



public class UseThisDemo {
  public void lambda() {
    // String hi = "HI";   // final로 인식함

    UseThis u1 = new UseThis() {
      @Override
      public void use() {
        System.out.println(this);
        // hi = hi + "Lamda. ";   // final로 인식해서 오류남
      }
    };
    u1.use();

    // Lamda
    UseThis u2 = () -> {
      System.out.println(this);
    };
    u2.use();
  }

  public String toString() {
    return "UsethisDemo";
  }
  public static void main(String[] args) {
    // int one = 1; // final로 인식
    new UseThisDemo().lambda();
    // Comparator<String> c1 = new Comparator<String>() {
    //   @Override
    //   public int compare(String one, String two) {
    //     return one.length() - two.length();
    //   }
    // };

    // Comparator<String> c = (one, two) -> one.length() - two.length();  // one은 오류


  }
}
