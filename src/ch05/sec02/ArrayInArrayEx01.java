package ch05.sec02;

public class ArrayInArrayEx01 {
	public static void main(String[] args) {
		
		int[][] mathScores = new int[2][3];
		for (int i=0; i<mathScores.length; i++) {
			for (int j=0; j<mathScores[i].length; j++) {
				System.out.printf("mathScores[%d][%d] = %d\n",i, j, mathScores[i][j]);
			}

		}
		System.out.println();
		
		int[][] EngScores = new int[2][];
		EngScores[0] = new int[2];
		EngScores[1] = new int[3];
		for (int i=0; i<EngScores.length; i++) {
			for (int j=0; j<EngScores[i].length; j++) {
				System.out.printf("EngScores[%d][%d] = %d\n",i, j, EngScores[i][j]);
			}

		}
		System.out.println();
		
		int javaScore[][] = {{95, 80}, {92, 96, 80}};
		for (int i=0; i<javaScore.length; i++) {
			for (int j=0; j<javaScore[i].length; j++) {
				System.out.printf("javaScore[%d][%d] = %d\n",i, j, javaScore[i][j]);
			}
		}
	}
}
