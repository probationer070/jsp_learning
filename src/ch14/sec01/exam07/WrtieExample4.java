package ch14.sec01.exam07;

import java.io.FileWriter;
import java.io.Writer;

public class WrtieExample4 {
    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("./test10.txt");

        String str = "ABCD";
        writer.write(str);

        writer.flush();
        writer.close();
    }
}
