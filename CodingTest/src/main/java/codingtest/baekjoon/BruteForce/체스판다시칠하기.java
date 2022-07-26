package codingtest.baekjoon.BruteForce;

import java.util.Scanner;

public class 체스판다시칠하기 {
	
	public static boolean[][] arr;
	public static int min = 64;

	public static void main(String[] args) {

		Scanner in 	= new Scanner(System.in);
		int N 		= in.nextInt();
		int M 		= in.nextInt();
		arr 		= new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = in.next();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}//end if()
			}//end for()
		}//end for()

		int N_row = N - 7;
		int M_col = M - 7;

		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}//end for()
		}//end for()
		System.out.println(min);
	}//end main()

	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;

		boolean TF = arr[x][y]; // 첫 번째 칸의 색

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

				if (arr[i][j] != TF) count++;

				TF = (!TF);
			}//end for()

			TF = !TF;
		}//end for()

		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}//end find()
	
}//end class()