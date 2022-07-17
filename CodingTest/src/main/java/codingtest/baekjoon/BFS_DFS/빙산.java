package codingtest.baekjoon.BFS_DFS;

import java.util.HashMap;
import java.util.Scanner;

public class 빙산 {
	
	private static int[][] map;
	private static boolean[][] vitied;
	private static HashMap<String, Integer> melt;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result 	= 0;
		int N 	= sc.nextInt();
		int M 	= sc.nextInt();
		map 	= new int[N][M];
		
		for(int a = 0 ; a < N ; a++) {
			for(int b = 0 ; b < M ; b++) {
				map[a][b] = sc.nextInt();
			}//end for()
		}//end for()
		
		while(true) {
			
			//빙산 체크
			boolean pass = print(N, M);
			
			//다 녹지 않았다면.
			if(pass) {
				
				//빙산 분리 체크
				vitied		= new boolean[N][M];
				int areaCnt = 0;
				for(int a = 0 ; a < N ; a++) {
					for(int b = 0 ; b < M ; b++) {
						int mapState = map[a][b];
						if(mapState != 0 && !vitied[a][b]) {
							dfs(a, b);
							areaCnt++;
						}//end if()
					}//end for()
				}//end for()
				
				//빙산 녹이기
				melt = new HashMap<String, Integer>();
				
				for(int a = 0 ; a < N ; a++) {
					for(int b = 0 ; b < M ; b++) {
						int mapState = map[a][b];
						if(mapState == 0) glacierMelt(a, b);
					}//end for()
				}//end for()
				meltProcess();
				
				if(1 < areaCnt) break;
				result++;
				
			//다 녹았다면.
			} else {
				result = 0;
				break;
			}//end if()
			
		}//end while()
		
		System.out.println(result);
	}//end main()

	private static void dfs(int a, int b) {
		vitied[a][b] = true;
		
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(map[moveX][moveY] == 0) continue;
			if(vitied[moveX][moveY]) continue;
			
			dfs(moveX, moveY);
			
		}//end for()
		
	}//end dfs()

	private static void meltProcess() {
		for(String key : melt.keySet()) {
			int x 		= Integer.parseInt(key.split(",")[0]);
			int y 		= Integer.parseInt(key.split(",")[1]);
			int value 	= melt.get(key);
			int mapVal	= map[x][y];
			
			if(mapVal < value) map[x][y] = 0;
			else map[x][y] = mapVal - value;
		}//end for()
	}//end meltProcess()

	private static boolean print(int N, int M) {
		for(int a = 0 ; a < N ; a++) {
			for(int b = 0 ; b < M ; b++) {
				if(map[a][b] != 0) {
					return true;
				}//end if()
			}//end for()
		}//end for()
		
		return false;
	}//end print()

	private static void glacierMelt(int a, int b) {
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(map[moveX][moveY] == 0) continue;
			
			String key = moveX + ","+ moveY;
			
			if(melt.containsKey(key)) {
				melt.put(key, melt.get(key) + 1);	
			} else {
				melt.put(key, 1);
			}//end if()
		}//end for()
	}//end glacierMelt()

}//end class()