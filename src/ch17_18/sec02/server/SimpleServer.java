package ch17_18.sec02.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
  public static void main(String[] args) {
    try(ServerSocket server = new ServerSocket(5000)) {
        Socket connection = server.accept();

        InputStream is = connection.getInputStream();
        OutputStream os = connection.getOutputStream();
        ObjectInputStream ois = new ObjectInputStream(is);  // 직렬화, 빨리 받기 위한
        ObjectOutputStream oos = new ObjectOutputStream(os);  // 직렬화, 빨리 받기 위
        String str = null;
        while (true) {
        	str = (String) ois.readObject();
        	if(str.equals("end")) {
            	oos.writeObject("bye");
            	server.close();
            } else {
            	oos.writeObject("서버에서 전송 : "+ str);
            	System.out.println("받은 문자열 = "+ str);
            }
        }
        
    } catch (Exception e) {}
  }
}
