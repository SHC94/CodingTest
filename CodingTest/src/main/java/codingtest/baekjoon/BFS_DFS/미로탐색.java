package codingtest.baekjoon.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {

	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		
		for(int a = 0 ; a < N ; a++) {
			String str = sc.next();
			for(int b = 0 ; b < str.length(); b++) {
				map[a][b] = Character.getNumericValue(str.charAt(b));
			}//end for()			
		}//end for()

		int result = bfs(map);
		
		System.out.println(result);
	}//end main()

	private static int bfs(int[][] map) {
		int result				= 0;
		//방문 여부
		boolean[][] visited 	= new boolean[map.length][map[0].length];
		visited[0][0] 			= true;
		
		Queue<Coordi> queue		= new LinkedList<Coordi>();
		queue.add(new Coordi(0, 0, 1));
		
		//이동 경로
		int[][] parttern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		while(!queue.isEmpty()) {
			Coordi coordi = queue.poll();
			int x = coordi.x;
			int y = coordi.y;
			int distance = coordi.distance;
			
			if(x == map.length - 1 && y == map[0].length - 1) {
				result = distance;
			}//end if()
			
			for(int a = 0 ; a < parttern.length ; a++) {
				int moveX = x + parttern[a][0];
				int moveY = y + parttern[a][1];
				
				//맵 범위를 벗어나는 경우
				if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
				
				//방문 했던 경로인 경우
				if(visited[moveX][moveY]) continue;
				
				//이동할 수 없는 칸인 경우
				if(map[moveX][moveY] == 0) continue;
				
				visited[moveX][moveY] = true;
				queue.add(new Coordi(moveX, moveY, distance + 1));
			}//end for()
			
		}//end while()
		
		return result;
	}//end bfs()
	
}//end class()

class Coordi {
	int x;
	int y;
	int distance;
	
	public Coordi(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}//end class()