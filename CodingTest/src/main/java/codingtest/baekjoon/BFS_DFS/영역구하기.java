package codingtest.baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 영역구하기 {

	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};	//이동 방향
	private static int[][] map;												//전체 맵
	private static boolean[][] visited;										//방문 여부
	private static List<Integer> resultList = new ArrayList<Integer>();		//결과값
	private static int area;												//영역의 크기
	
	public static void main(String[] args) {
//		눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다
//		이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 
//		이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
		
		//첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다
		Scanner sc = new Scanner(System.in);
		int M 	= sc.nextInt();		//가로 갯수
		int N 	= sc.nextInt();		//세로 갯수
		int K 	= sc.nextInt();		//사각형 갯수
		map 	= new int[N][M];	//맵
		visited	= new boolean[N][M];//방문여부
		
		//둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 
		//x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다.
		for(int a = 0 ; a < K ; a++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			//영역 채우기
			for(int x = x1 ; x < x2 ; x++) {
				for(int y = y1 ; y < y2 ; y++) {
					map[x][y] = 1;
				}//end for()
			}//end for()
			
		}//end for()
		
		for(int x = 0 ; x < N ; x++) {
			for(int y = 0 ; y < M ; y++) {
				area = 0;
				
				//방문한 적이 없는 빈 영역인 경우
				if(!visited[x][y] && map[x][y] == 0) {
					dfs(x, y);
				}//end if()
				
				if(0 < area) resultList.add(area);
			}//end for()
		}//end for()
		
//		첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.
		System.out.println(resultList.size());
		Collections.sort(resultList);
		for(int result : resultList) System.out.print(result + " ");
		
	}//end main()

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		area++;
		
		//이동하며 탐색
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = x + pattern[i][0];
			int moveY = y + pattern[i][1];
			
			//맵 범위를 넘어간 경우
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			
			//방문했던 곳인 경우
			if(visited[moveX][moveY]) continue;
			
			//사각형 영역인 경우
			if(map[moveX][moveY] == 1) continue;
			
			dfs(moveX, moveY);
		}//end for()
		
	}//end dfs()

}//end class()