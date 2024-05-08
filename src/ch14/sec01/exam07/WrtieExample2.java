package ch14.sec01.exam07;

import java.io.FileWriter;
import java.io.Writer;

public class WrtieExample2 {
    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("./test8.txt");

        char[] arr = { 'A', 'B', 'C' };
        writer.write(arr);

        writer.flush();
        writer.close();
    }
}
