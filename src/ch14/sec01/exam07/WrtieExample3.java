package ch14.sec01.exam07;

import java.io.FileWriter;
import java.io.Writer;

public class WrtieExample3 {
    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("./test9.txt");

        char[] arr = { 'A', 'B', 'C', 'D', 'E' };
        writer.write(arr, 1, 3);

        writer.flush();
        writer.close();
    }
}
