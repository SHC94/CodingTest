package codingtest.baekjoon.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 양 {
	
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static boolean[][] visited;
    private static String[][] map;
	private static int sheep = 0;
    private static int wolf = 0;

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
        int R 		= sc.nextInt();
        int C 		= sc.nextInt();
        map 		= new String[R][C];
        visited 	= new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }//end for()
        }//end for()
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && !"#".equals(map[i][j])) {
                    bfs(i, j);
                }//end if()
            }//end for()
        }//end for()
        System.out.println(sheep + " " + wolf);
	}//end main()


	private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        
        visited[i][j] = true;
        
        int wolfCnt 	= 0;
        int sheepCnt 	= 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            
            if ("o".equals(map[x][y])) sheepCnt++;
            else if ("v".equals(map[x][y])) wolfCnt++;
            
            for (int a = 0; a < 4; a++) {
                int moveX = x + pattern[a][0];
                int moveY = y + pattern[a][1];
                
                if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue; 
                if(visited[moveX][moveY]) continue;
                if("#".equals(map[moveX][moveY])) continue;
                
                visited[moveX][moveY] = true;
                queue.add(new Point(moveX, moveY));
                
            }
        }//end while()
        
        if (sheepCnt > wolfCnt) sheep += sheepCnt;
        else wolf += wolfCnt;

    }//end bfs()
	
}//end class()

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}