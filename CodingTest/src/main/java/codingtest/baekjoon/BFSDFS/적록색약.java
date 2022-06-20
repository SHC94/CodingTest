package codingtest.baekjoon.BFSDFS;

import java.util.Scanner;

public class 적록색약 {

	private static int[][] pattern = {{1,0}, {-1,0}, {0,1}, {0,-1}};	//이동 패턴
	private static boolean[][] visited;	//방문여부
	private static String[][] map;		//전체 맵
	private static int result;			//결과
	private static String gijun;		//이동 기준
	
	
	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		map 		= new String[N][N];
		StringBuilder sb = new StringBuilder();
		
		//입력 값 저장
		for(int a = 0 ; a < N ; a++) {
			String rgb = sc.next();
			for(int b = 0 ; b < rgb.length() ; b++) {
				map[a][b] = String.valueOf(rgb.charAt(b)); 
			}//end for()
		}//end for()
		
		
		//dfs
		boolean[] testcase = {true, false};
		
		for(int test = 0 ; test < testcase.length ; test++) {
			//초기화
			initialization(N, testcase[test]);
			
			for(int a = 0 ; a < map.length ; a++) {
				for(int b = 0 ; b < map[a].length ; b++) {
					if(!visited[a][b]) {
						dfs(a, b);
						result++;
					}//end if()
				}//end for()
			}//end for()
			
			if(test == 0) 	sb.append(result).append(" ");
			else 			sb.append(result);
			
		}//end for()
		
		System.out.println(sb.toString());
	}//end main()

	private static void initialization(int N, boolean testcase) {
		
		visited = new boolean[N][N];	//방문여부
		result 	= 0;					//결과
		
		//G >> R 변경
		if(!testcase) {
			for(int a = 0 ; a < N ; a++) {
				for(int b = 0 ; b < N ; b++) {
					if(map[a][b].equals("G")) map[a][b] = "R";
				}//end for()
			}//end for()
		}//end if()
		
	}//end initialization()

	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		gijun = map[x][y];
		
		for(int i = 0 ; i < pattern.length; i++) {
			int moveX = x + pattern[i][0];
			int moveY = y + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(visited[moveX][moveY]) continue;
			if(!map[moveX][moveY].equals(gijun)) continue;
			dfs(moveX, moveY);
		}//end for()
		
	}//end dfs()
	
}//end class()