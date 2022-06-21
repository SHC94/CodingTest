package codingtest.baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 단지번호붙이기 {
	
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};	//이동 방향
	private static int[][] map;												//아파트 단지
	private static boolean[][] visited;										//방문 여부
	private static List<Integer> resultList = new ArrayList<Integer>();		//결과
	private static int houseCnt;											//가구 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 
		int N 	= sc.nextInt();
		map 	= new int[N][N];
		visited	= new boolean[N][N];
		
//		그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
		//아파트 단지 정보 입력
		for(int a = 0 ; a < N ; a++) {
			String str = sc.next();
			for(int b = 0 ; b < str.length() ; b++) {
				map[a][b] = Character.getNumericValue(str.charAt(b));
			}//end for()
		}//end for()
		
		//단지 탐색
		for(int a = 0 ; a < map.length ; a++) {
			for(int b = 0 ; b < map[a].length ; b++) {
				houseCnt = 0;
				
				//방문한 적이 없는 집인 경우
				if(!visited[a][b] && map[a][b] == 1) dfs(a, b);
				
				if(0 < houseCnt) resultList.add(houseCnt);
			}//end for()
		}//end for()
		
		System.out.println(resultList.size());
		Collections.sort(resultList);
		for(int result : resultList) System.out.println(result);
	}//end main()

	private static void dfs(int a, int b) {
		visited[a][b] = true;
		houseCnt++;
		
		//이동 가능 지역 탐색
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			//맵 범위를 넘어간 경우
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			
			//방문한 곳인 경우
			if(visited[moveX][moveY]) continue;
			
			//집이 없는 경우
			if(map[moveX][moveY] == 0) continue;
			
			//다음 지역 탐색
			dfs(moveX, moveY);
			
		}//end for()
				
	}//end dfs()
	
}//end class()