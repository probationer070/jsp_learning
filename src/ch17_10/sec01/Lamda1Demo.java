package ch17_10.sec01;

import java.util.Arrays;

public class Lamda1Demo {
  public static void main(String[] args) {
    String[] str = {
      "로마에 가면 로마법을 따르다",
      "시간은 돈이다",
      "펜은 칼보다 강하다" };

    Arrays.sort(str, (String first, String second) -> first.length() - second.length());
    for (String s: str) {
      System.out.println(s);
    }
  }

  // public static int[] lengComp(String str[]) {
  //   int res[] = new int[str.length];
  //   for (int i=0; i<str.length-1;  i++) {
  //     res[i] = str[i].length() - str[i+1].length();
  //   }
  //   return res;
  // }
}
