package ch14.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExampel {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("D:/EcomWork/WorkSpace6/JavaEx/src/test1.db");

        byte a = 10;
        byte b = 20;
        byte c = 30;

        os.write(a);
        os.write(b);
        os.write(c);

        os.flush();
        os.close();
    }
}
