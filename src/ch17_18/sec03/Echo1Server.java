package ch17_18.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo1Server {
  public static void main(String[] args) throws IOException {
    ServerSocket server = null;
    Socket connection = null;
    BufferedReader br = null;

    server = new ServerSocket(5000);
    System.out.println("연결 대기중...");
    connection = server.accept();
    System.out.println("메세지 기다리는 중...");
    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

    String msg;
    while((msg = br.readLine()) != null) {
      System.out.println("읽은 메세지 메아리 : " + msg);
    }
    System.out.println("서버 종료");
    br.close();
    connection.close();
    server.close();
  }

  
}
