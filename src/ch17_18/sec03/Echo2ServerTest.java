package ch17_18.sec03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo2ServerTest extends Thread {
  protected static boolean cont = true;
  protected Socket connection = null;
  public static void main(String[] args) throws IOException {
    ServerSocket server = null;
    server = new ServerSocket(5000);
    System.out.println("서버 소켓 생성");
    while(cont) {
      System.out.println("연결 대기 중...");
      new Echo2ServerTest(server.accept());
    }
    server.close();
  }
  
  private Echo2ServerTest(Socket clientSocket) {
    connection = clientSocket;
    start();
  }
  
  @Override
  public void run() {
    BufferedReader br = null;
    BufferedWriter bw = null;
    System.out.println("클라이언트와 통신을 위한 새로운 스레드 생성");
    try {
      br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
      String msg;
      while((msg = br.readLine()) != null) {
    	System.out.print("보내기 >> ");
    	String outMsg = br.readLine();
    	bw.write(outMsg + "\n");
    	bw.flush();
		
        System.out.println("읽은 메시지 메아리 : " + msg);
      }
      br.close();
      connection.close();
    } catch (IOException e) {}
  }

  
}
