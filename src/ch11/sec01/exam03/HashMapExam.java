package ch11.sec01.exam03;

import java.util.HashMap;

public class HashMapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> h1 = new HashMap<String, Integer>();
		
		h1.put("ss", 50);
		h1.put("dd", 20);
		
		System.out.println(h1.get("ss"));
		System.out.println(h1.get("dd"));
	}

}
