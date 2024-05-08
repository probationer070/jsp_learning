package ch14.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExampel3 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("./test3.db");

        byte[] arr = { 10, 20, 30, 40, 50 };

        os.write(arr, 1, 3);

        os.flush();
        os.close();
    }
}
