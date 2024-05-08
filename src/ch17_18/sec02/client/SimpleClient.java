package ch17_18.sec02.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
  public static void main(String[] args) {
    try (Socket client = new Socket("localhost", 5000);
    		
    	 InputStream is = client.getInputStream();
         OutputStream os = client.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(os);) {
    	ObjectInputStream ois = new ObjectInputStream(is);
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		String msg = sc.nextLine();
    		oos.writeObject(msg);
    		oos.flush();
    		String s= (String) ois.readObject();
    		if(msg.equals("end")) {
    			break;
    		} else {
    			System.out.println(s);
    		}
    	}
    	
    	sc.close();
        ois.close();
    } catch (Exception e) {}
  }
}
