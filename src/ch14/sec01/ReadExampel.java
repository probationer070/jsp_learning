package ch14.sec01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExampel {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("./test1.db");
        while (true) {
            int data = is.read();
            if (data == -1)
                break;
            System.out.println(data);
        }
        is.close();
    }
}
