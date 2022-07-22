package codingtest.baekjoon.BFS_DFS;

import java.util.Scanner;

public class 음식물피하기 {
	
	private static String[][] map;
	private static boolean[][] visited;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x 	= sc.nextInt();
		int y 	= sc.nextInt();
		int g 	= sc.nextInt();
		
		map 	= new String[x][y];
		visited	= new boolean[x][y]; 
		
		int answer = 0;
		for(int a = 0 ; a < g ; a++) {
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			map[x2 - 1][y2 - 1] = "#";
		}//end for()
		
		for(int a = 0 ; a < x ; a++) {
			for(int b = 0 ; b < y ; b++) {
				if("#".equals(map[a][b]) && !visited[a][b]) {
					dfs(a, b);	
				}//end if()
				
				if(answer < result) answer = result;
				result = 0;
			}//end for()
		}//end for()
		
		System.out.println(answer);
	}//end main()

	private static void dfs(int a, int b) {
		visited[a][b] = true;
		
		result++;
		
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(visited[moveX][moveY]) continue;
			if(!"#".equals(map[moveX][moveY])) continue;

			dfs(moveX, moveY);
		}//end for()
	}//end dfs()
	
}//end class()