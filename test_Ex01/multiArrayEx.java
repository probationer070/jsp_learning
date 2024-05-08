package test_Ex01;

public class multiArrayEx {
	public static void main(String[] args) {
//		int arr[][] = { new int[4],
//						new int[4],
//						new int[3],
//						new int[2]
//		};
		
		int arr[][] = {{20, 20, 20, 20},
					   {30, 30, 30, 30},
					   {30, 40, 40},
					   {50, 50}
		};
		int i=0;
		while (i < arr.length) {
			System.out.println(arr[i].length);
			i++;
		}
		
		for (int a=0; a<arr.length; a++) {
			for (int b=0; b<arr[a].length; b++) {
				System.out.println(a+"층 "+b+"방:"+arr[a][b]);
			}
			System.out.println("NEXT Floor");
		}
	}
}
