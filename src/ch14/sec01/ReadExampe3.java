package ch14.sec01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExampe3 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("./test3.db");
        byte[] buffer = new byte[5];

        int readByteNum = is.read(buffer, 2, 3);
        if (readByteNum != -1) {
            for (int i = 0; i < buffer.length; i++) {
                System.out.println(buffer[i]);
            }
        }
        is.close();
    }
}
