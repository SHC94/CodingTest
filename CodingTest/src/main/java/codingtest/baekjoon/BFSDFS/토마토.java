package codingtest.baekjoon.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 토마토 {
	
	private static int[][] pattern = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	private static int[][] map;
	private static Queue<Tomato> queue = new LinkedList<Tomato>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M 	= sc.nextInt(); 	// 가로
		int N 	= sc.nextInt(); 	// 세로
		map 	= new int[N][M]; 	// 토마토 밭

		for (int a = 0 ; a < N ; a++) {
			for (int b = 0 ; b < M ; b++) {
				
				map[a][b] = sc.nextInt();
				if (map[a][b] == 1) queue.add(new Tomato(a, b));
				
			}//end for()
		}//end for()
		
		int result = bfs();
		
		System.out.println(result);
	}//end main()

	public static int bfs() {
		
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			int x = tomato.x;
			int y = tomato.y;

			for (int i = 0; i < pattern.length; i++) {
				
				int moveX = pattern[i][0] + x;
				int moveY = pattern[i][1] + y;

				//맵 범위를 넘어선 경우
				if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
				
				//토마토가 익지 않은 상태가 아닌 경우
				if (map[moveX][moveY] != 0) continue;

				queue.add(new Tomato(moveX, moveY));
				map[moveX][moveY] = map[x][y] + 1;

			}//end for()
			
		}//end while()

		// 날짜 출력
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {

				//익지 않은 토마토가 있는 경우
				if (map[i][j] == 0)	return -1;
				
				//토마토 익은 날짜 최대값
				result = Math.max(result, map[i][j]);

			}//end for()
		}//end for()

		if (result == 1) 	return 0;			// 전부 1일인 경우, 애초에 다 익어 있엇음.
		else				return result - 1;	// 최대 일자
	}//end bfs()
	
}//end class()

class Tomato {
	int x;
	int y;

	Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}//end class()