package ch14.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExampel2 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("./test2.db");

        byte[] arr = { 10, 20, 30 };

        os.write(arr);

        os.flush();
        os.close();
    }
}
