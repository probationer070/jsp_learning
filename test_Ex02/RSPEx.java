package test_Ex02;

import java.util.Scanner;

public class RSPEx {
	public static boolean check_win(int a, int b) {
		if (a==0 && b==2) return true; 
		else if (a==1 && b==0) return true; 
		else if (a==2 && b==1) return true;
		else return false;
	}
	

	public static void main(String[] args) {
		System.out.println("[가위바위보 게임]");
		while(true) {
			System.out.println("---------------------");
			System.out.println("메뉴 > 1. 게임하기 2. 종료");
			System.out.println("---------------------");
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();	
			
			if (input == 1) {
				System.out.println("가위: 0, 바위: 1, 보:2");
				System.out.println("---------------------");
				int com_num = (int)Math.floor(Math.random() * 3);
				int my_num = sc.nextInt();
				switch(my_num) {
				case 0:
				case 1:
				case 2:
					if (check_win(my_num, com_num)) {
						System.out.println("you win");
					} else {
						System.out.println("you lose");
					}
					System.out.println("---------------------");
					break;
				default:
					System.out.println("Wrong Number");				
				}
			} else {
				System.exit(0);
			}
		}
		
	}
}
