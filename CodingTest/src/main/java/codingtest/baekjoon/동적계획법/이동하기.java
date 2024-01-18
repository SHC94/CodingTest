package codingtest.baekjoon.동적계획법;

import java.util.Scanner;

public class 이동하기 {

	public static void main(String[] args){
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		int M 		= sc.nextInt();
		int[][] map = new int[N + 1][M + 1];
		int max 	= -1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();

				max = Math.max(map[i][j - 1], Math.max(map[i - 1][j - 1], map[i - 1][j]));
				map[i][j] += max;
			}//end for()
		}//end for()`

		System.out.println(map[N][M]);

	}//end main()

}//end class()