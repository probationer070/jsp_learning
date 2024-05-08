package ch14.sec02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AddLineNumberExample {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("./ch14/sec02/AddLineNumberExample.txt");

        String filePath = "./ch14/sec02/AddLineNumberExample.java";
        Reader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);

        while (true) {
            String data = br.readLine();
            if (data == null)
                break;
            writer.write(data);
            System.out.println(data);
        }
        writer.flush();
        writer.close();

        br.close();
    }
}
