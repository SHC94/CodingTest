package codingtest.baekjoon.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물섬 {

	private static String[][] map;
	private static boolean[][] visited;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int L 		= sc.nextInt();
        int W 		= sc.nextInt();
        map			= new String[L][W];
        
        
        //맵 그리기
        for(int a = 0 ; a < L ; a++) {
        	String str = sc.next();
        	for(int b = 0 ; b < str.length() ; b++) {
        		map[a][b] = String.valueOf(str.charAt(b));
        	}//end for()
        }//end for()
        
        //탐색
        for(int a = 0 ; a < map.length ; a++) {
        	for(int b = 0 ; b < map[a].length ; b++) {
        		visited = new boolean[L][W];	//케이스마다 방문 여부 초기화
        		if("L".equals(map[a][b])) {
        			bfs(a, b);					//탐색
        		}//end if()
            }//end for()
        }//end for()
        
        System.out.println(result);
    }//end main()

	private static void bfs(int a, int b) {
		Queue<Treasure> queue = new LinkedList<Treasure>();
		queue.add(new Treasure(a, b, 0));
		visited[a][b] = true;
		
		while(!queue.isEmpty()) {
			Treasure treasure = queue.poll();
			int x 	= treasure.x;
			int y 	= treasure.y;
			int dis = treasure.dis;
			
			if(result < dis) result = dis;
			
			for(int i = 0 ; i < pattern.length ; i++) {
				int moveX = x + pattern[i][0];
				int moveY = y + pattern[i][1];
				
				//탐색 중지 케이스
				//맵 범위를 넘어서는 경우 
				if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
				
				//방문했던 경로인 경우
				if(visited[moveX][moveY]) continue;
				
				//바다인 경우
				if("W".equals(map[moveX][moveY])) continue;
				
				//방문 체크
				visited[moveX][moveY] = true;
				
				queue.add(new Treasure(moveX, moveY, dis + 1));
			}//end for()
			
		}//end while()
	}//end bfs()
	
}//end class()

class Treasure {
	int x;
	int y;
	int dis;
	
	public Treasure(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}//end class()