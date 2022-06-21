package codingtest.baekjoon.BFS_DFS;

import java.util.Map;
import java.util.Scanner;

public class 안전영역 {

	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};	//이동 방향
	private static boolean[][] visited;			//방문 여부
	private static int[][] map;					//지역 맵
	private static int result = 0;				//안전 지역
	private static int max = 0;	//결과값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다
		//N은 2 이상 100 이하의 정수이다. 
		int N = sc.nextInt();
		
		//둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다.
		//지형 설정
		map 		= new int[N][N];
		int maxH	= 0;
		
		for(int a = 0 ; a < map.length ; a++) {
			for(int b = 0 ; b < map[a].length ; b++) {
				int height = sc.nextInt();
				map[a][b] = height;
				if(maxH < height) maxH = height;
			}//end for()
		}//end for()
		
		//!!!!!!!!!!높이는 1이상 100 이하의 정수이다.!!!!!!!!!!!!
		for(int i = 0 ; i < maxH + 1 ; i++) {
			//비의 높이마다 안전 영역의 수 확인
			result 		= 0;
			visited		= new boolean[N][N];
			
			//안전 영역 확인
			for(int a = 0 ; a < map.length ; a++) {
				for(int b = 0 ; b < map[a].length ; b++) {
					//방문한적이 없거나 잠긴 지역이 아닌 경우 탐색 가능
					if(!visited[a][b] && i < map[a][b]) {
						
						dfs(a, b, i);
						result++;
						
					}//end if()
				}//end for()
			}//end for()
			
			max = Math.max(max, result);
		}//end for()
		
		System.out.println(max);
	}//end main()

	private static void dfs(int a, int b, int h) {
		//방문 체크
		visited[a][b] = true;
		
		//이동 가능 지역 탐색
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			//맵 범위를 넘어간 경우
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			
			//방문한 곳인 경우
			if(visited[moveX][moveY]) continue;
			
			//잠긴 지역인 경우
			if(map[moveX][moveY] <= h) continue;
			
			//다음 지역 탐색
			dfs(moveX, moveY, h);
			
		}//end for()
		
	}//end dfs()
	
}//end class()

