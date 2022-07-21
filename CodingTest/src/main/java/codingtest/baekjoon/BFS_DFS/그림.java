package codingtest.baekjoon.BFS_DFS;

import java.util.Scanner;

public class 그림 {
	
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int[][] map;
	private static boolean[][] visited;
	private static int result = 0;
	private static int maxArea = 0;
	
	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		int M 		= sc.nextInt();
		map			= new int[N][M];
		visited		= new boolean[N][M];
		int areaCnt = 0;
		
		for(int a = 0 ; a < N ; a++) {
			for(int b = 0 ; b < M ; b++) {
				map[a][b] = sc.nextInt();
			}//end for()
		}//end for()
		
		for(int a = 0 ; a < N ; a++) {
			for(int b = 0 ; b < M ; b++) {
				if(map[a][b] == 1 && !visited[a][b]) {
					dfs(a, b);
					areaCnt++;
				}//end if()
				
				if(result < maxArea) result = maxArea;
            	maxArea = 0;
			}//end for()
		}//end for()
		
		System.out.println(areaCnt);
		System.out.println(result);
	}//end main()

	private static void dfs(int a, int b) {
		visited[a][b] = true;
		
		maxArea++;
		
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(visited[moveX][moveY]) continue;
			if(map[moveX][moveY] == 0) continue;
			
			dfs(moveX, moveY);
		}//end for()
				
	}//end dfs()
	
}//end class()