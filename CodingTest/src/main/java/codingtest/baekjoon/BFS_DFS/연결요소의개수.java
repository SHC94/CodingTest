package codingtest.baekjoon.BFS_DFS;

import java.util.Scanner;

public class 연결요소의개수 {

	private static int N;
	private static int M;
	private static int[][] matrix;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		matrix = new int[N + 1][N + 1];

		for (int i = 0 ; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}//end for()

		visited = new boolean[N + 1];

		int cnt = 0;

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}//end if()
		}//end for()

		System.out.println(cnt);
	}//end main()

	private static void dfs(int start) {

		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (matrix[start][i] == 1 && !visited[i]) {
				dfs(i);
			}//end if()
		}//end for()
		
	}//end dfs()

}//end class()
