package ch17_18.sec02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class InetAddressDemo {
  public static void main(String[] args) throws IOException {
    InetAddress addr1 = null, addr2 = null;
    System.out.print("호스트 이름을 입력하시오 : ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String url = br.readLine();
    addr1 = InetAddress.getByName(url);
    addr2 = InetAddress.getLocalHost();

    System.out.print(url+"의 IP주소: ");
    System.out.println(addr1.getHostAddress());
    System.out.print("로컬 IP주소: ");
    System.out.println(addr2.getHostAddress());
  
  }
}
