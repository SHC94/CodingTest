package codingtest.baekjoon.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈 {
	
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;
    private static int[][] board;
    private static int n, m;
    private static int cheese;
    
	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		n 			= sc.nextInt();
		m 			= sc.nextInt();
		board 		= new int[n][m];
		cheese 		= 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 1) {
					cheese++;
				}//end if()
			}//end for()
		}//end for()

		int cheeseCount = 0;
		int time 		= 0;
		while (cheese != 0) {
			cheeseCount = cheese;
			time++;
			visited = new boolean[n][m];
			bfs();
		}//end while()
		System.out.println(time);
		System.out.println(cheeseCount);
	}//end main()

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current[0] + pattern[i][0];
				int ny = current[1] + pattern[i][1];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					if (board[nx][ny] == 0) {
						q.offer(new int[] { nx, ny });
					} else {
						cheese--;
						board[nx][ny] = 0;
					}//end if()
				}//end if()
			}//end for()
		}//end while()
	}//end bfs()
	
}//end class()