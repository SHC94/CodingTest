package codingtest.baekjoon.BFS_DFS;

import java.util.Scanner;

public class 섬의개수 {

	private static int[][] pattern = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};	//이동 패턴
	private static int[][] map;
	private static boolean[][] visited;
	private static int result;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
			//w와 h는 50보다 작거나 같은 양의 정수이다.
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			//입력의 마지막 줄에는 0이 두 개 주어진다.
			if(w == 0 && h == 0) break; 
			map 	= new int[h][w];
			visited	= new boolean[h][w];
			result  = 0;
			
			//둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
			for(int a = 0 ; a < map.length ; a++) {
				for(int b = 0 ; b < map[a].length ; b++) {
					map[a][b] = sc.nextInt();
				}//end for()
			}//end for()
			
			//맵 하나씩 탐색
			for(int a = 0 ; a < map.length ; a++) {
				for(int b = 0 ; b < map[a].length ; b++) {
					
					//방문한 적이 없는 땅인 경우 탐색
					if(!visited[a][b] && map[a][b] == 1) {
						dfs(a, b);
						result++;
					}//end if()
				}//end for()
			}//end for()
			
			//각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
			System.out.println(result);
		}//end while()
		
	}//end main()

	private static void dfs(int a, int b) {
		visited[a][b] = true;
		
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(visited[moveX][moveY]) continue;
			if(map[moveX][moveY] == 0) continue;
			
			//이동할 수 있는 경우 다시 탐색
			dfs(moveX, moveY);
		}//end for()
		
	}//end dfs()
	
}//end class()