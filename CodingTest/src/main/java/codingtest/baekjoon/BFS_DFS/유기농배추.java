package codingtest.baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {

	private static boolean[][] visited;
	private static int[][] pattern = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	private static int result;
	private static List<Integer> resultList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		//입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
		//그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
		//그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
		//그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다
		
		//각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	//테이스 케이스 수
		
		for(int a = 0 ; a < T ; a++) {
			int M = sc.nextInt();	//배추밭의 가로길이
			int N = sc.nextInt();	//배추밭의 세로길이
			int K = sc.nextInt();	//배추 갯수
			
			int[][] map 	= new int[M][N];		//밭
			visited 		= new boolean[M][N];	//방문 여부
			result			= 0;
			
			//배추 심기
			for(int b = 0 ; b < K ; b++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[X][Y] = 1;
			}//end for()
			
			//지렁이 세보기
			for(int c = 0 ; c < map.length ; c++) {
				for(int d = 0 ; d < map[0].length ; d++) {
					bfs(map, c, d);
				}//end for()
			}//end for()
			
			resultList.add(result);
		}//end for()
		
		for(int q = 0 ; q < resultList.size() ; q++) {
			System.out.println(resultList.get(q));
		}
	}//end main()
	
	private static void bfs(int[][] map, int c, int d) {
		//배추가 심어져 있지 않은 땅의 경우 아래 로직 실행 x
		if(map[c][d] == 0 || visited[c][d]) return;
		
		//배추 갯수
		int cabbageCnt 	= 0;
		
		//탐색용 큐 생성
		Queue<Earthworm> queue = new LinkedList<Earthworm>();
		queue.add(new Earthworm(c, d, 1));
		
		//방문 여부 체크
		visited[c][d] = true;
		
		while(!queue.isEmpty()) {
			//현재 위치
			Earthworm earthworm = queue.poll();
			int x 		= earthworm.x;
			int y 		= earthworm.y;
			int cabbage = earthworm.cabbage;
			cabbageCnt	= cabbage;
			
			//배추 탐색 시작
			for(int a = 0 ; a < pattern.length ; a++) {
				//이동할 위치
				int moveX = pattern[a][0] + x;
				int moveY = pattern[a][1] + y;
				
				//유효성 체크
				//맵 범위를 벗어난 경우
				if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
				
				//이미 방문한 경우
				if(visited[moveX][moveY]) continue;
				
				//배추가 없는 경우
				if(map[moveX][moveY] == 0) continue;
				
				visited[moveX][moveY] = true;
				queue.add(new Earthworm(moveX, moveY, cabbage + 1));
			}//end for()
		}//end while()
		
		if(0 < cabbageCnt) result++;
	}//end bfs()

}//end class()

class Earthworm {
	int x;
	int y;
	int cabbage;
	public Earthworm(int x, int y, int cabbage) {
		this.x = x;
		this.y = y;
		this.cabbage = cabbage;
	}//end Earthworm()
	
}//end class()