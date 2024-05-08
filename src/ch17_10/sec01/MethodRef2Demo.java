package ch17_10.sec01;

class Box {
  int no;
  public Box(int no) {
    this.no = no;
  }

  boolean isSame(Box b) {
    return this.no == b.no;
  }
}

interface Applyable {
  boolean apply(Box a, Box b);
}

public class MethodRef2Demo {
  public static void main(String[] args) {
    // Applyable app1 = new Applyable() {
    //   @Override
    //   public boolean apply(Box a, Box b) {
    //     // TODO Auto-generated method stub
    //     return a.isSame(b);
    //   }
    // };
    // System.out.println(app1.apply(new Box(1), new Box(2)));
    
    Applyable app;
    // app = (a, b) -> a.isSame(b);
    app = Box :: isSame;
    System.out.println(app.apply(new Box(2), new Box(2)));
  }
}
