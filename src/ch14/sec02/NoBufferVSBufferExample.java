package ch14.sec02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class NoBufferVSBufferExample {

    public static void main(String[] args) throws Exception {
        String originalFilePath1 = NoBufferVSBufferExample.class.getResource("originalFile1.jpg").getPath();
        String targetFilePath1 = "./targetFile1.jpg";
        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        String originalFilePath2 = NoBufferVSBufferExample.class.getResource("originalFile2.jpg").getPath();
        String targetFilePath2 = "./targetFile2.jpg";
        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼를 사용하지 않았을 때 : " + nonBufferTime + "ns");

        long BufferTime = copy(bis, bos);
        System.out.println("버퍼를 사용했을 때 : " + BufferTime + "ns");

        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }

    static int data = -1;

    public static long copy(InputStream is, OutputStream os) throws Exception {
        long start = System.nanoTime();
        while (true) {
            data = is.read();
            if (data == -1)
                break;
            os.write(data);
        }
        os.flush();
        long end = System.nanoTime();
        return (end - start);
    }
}