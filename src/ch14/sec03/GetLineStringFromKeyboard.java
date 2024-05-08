package ch14.sec03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetLineStringFromKeyboard {
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        while (true) {
            System.out.println("입력하세요: ");
            String linestr = br.readLine();
            if (linestr.equals("q") || linestr.equals("quit"))
                break;
            System.out.println("입력된내용: " + linestr);
            System.out.println();
        }
        br.close();
    }
}
