package ch17_12.sec01;

public class Util {
  public static <T> void print(T t) {
    System.out.print(t+ " ");
  }

  public static <T> void printParenthesis(T t) {
    System.out.print("("+t+"), ");
  }
}

/*
  String s = "문자열";
  Util.print(s);
  
  Util:print

 */