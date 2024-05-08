package ch05;

import java.util.Scanner;

public class StringDemo02_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int res = 0;

        String arr[] = str.split("");

        for (int i = 0; i < (arr.length / 2); i++) {
            if (arr[i].equals(arr[arr.length - i - 1]) == false) {
                res = 0;
            } else {
                res = 1;
            }
        }
        sc.close();
        System.out.println(res);
    }
}
