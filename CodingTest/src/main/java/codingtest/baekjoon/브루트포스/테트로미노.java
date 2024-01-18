package codingtest.baekjoon.브루트포스;

import java.util.Scanner;

public class 테트로미노 {

	private static int N, M, ans;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] pattern = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		N 			= sc.nextInt();
		M 			= sc.nextInt();
		map 		= new int[N][M];
		visited 	= new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}//end for()
		}//end for()
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				check(i, j);
			}//end for()
		}//end for()
		
		System.out.println(ans);

	}//end main()

	private static void dfs(int y, int x, int cnt, int sum) {

		if (cnt >= 4) {
			ans = Math.max(ans, sum);
			return;
		}//end if()

		for (int k = 0; k < 4; k++) {
			int nx = y + pattern[k][0];
			int ny = x + pattern[k][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

			visited[nx][ny] = true;
			dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}//end for()
	}//end dfs()

	private static void check(int y, int x) {
		if (y < N - 2 && x < M - 1) ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);

		if (y < N - 2 && x > 0) 	ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);

		if (y < N - 1 && x < M - 2) ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);

		if (y > 0 && x < M - 2)		ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
	}// end check()
}// end class()