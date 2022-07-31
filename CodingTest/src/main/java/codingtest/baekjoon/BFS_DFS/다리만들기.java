package codingtest.baekjoon.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 다리만들기 {

	private static int[][] pattern = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int[][] map;
	private static boolean[][] visited;
	private static int N;
	private static int landNum = 2;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		N 			= sc.nextInt();
		map 		= new int[N][N];
		visited 	= new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}//end for()
		}//end for()

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					makeLand(r, c);
				}//end if()
			}//end for()
		}//end for()

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] >= 2) {
					visited = new boolean[N][N];
					bfs(r, c);
				}//end if()
			}//end for()
		}//end for()
		System.out.println(answer);
	}//end main()

	private static void makeLand(int r, int c) {
		Queue<Bridge> queue = new LinkedList<>();
		queue.offer(new Bridge(r, c, 0));
		visited[r][c] = true;
		map[r][c] = landNum;
		while (!queue.isEmpty()) {
			Bridge point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int r2 = point.r + pattern[i][0];
				int c2 = point.c + pattern[i][1];
				if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !visited[r2][c2] && map[r2][c2] == 1) {
					visited[r2][c2] = true;
					map[r2][c2] = landNum;
					queue.offer(new Bridge(r2, c2, 0));
				}//end if()
			}//end for()
		}//end while()
		landNum++;
	}//end makeLand()

	private static void bfs(int r, int c) {
		Queue<Bridge> queue = new LinkedList<Bridge>();
		queue.offer(new Bridge(r, c, 0));
		int currentLandNum 	= map[r][c];
		visited[r][c] 	= true;
		while (!queue.isEmpty()) {
			Bridge point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int r2 = point.r + pattern[i][0];
				int c2 = point.c + pattern[i][1];
				
				if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !visited[r2][c2] && map[r2][c2] != currentLandNum) {
					visited[r2][c2] = true;
					if (map[r2][c2] == 0) {
						queue.offer(new Bridge(r2, c2, point.cnt + 1));
					} else {
						answer = Math.min(answer, point.cnt);
					}//end if()
				}//end if()
				
			}//end for()
			
		}//end while()
	}//end bfs()

	static class Bridge {
		int r;
		int c;
		int cnt;

		public Bridge(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}//end class()
}// end class()

