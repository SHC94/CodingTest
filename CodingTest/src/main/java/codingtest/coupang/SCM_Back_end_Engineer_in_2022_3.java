package codingtest.coupang;

import java.util.LinkedList;
import java.util.Queue;

public class SCM_Back_end_Engineer_in_2022_3 {
	
	public static void main(String[] args) {
		
//		int[][] board		= {	{3, 2, 3, 2},
//								{2, 1, 1, 2},
//								{1, 1, 2, 1},
//								{4, 1, 1, 1}
//							};
		
//		int[][] board		= {	{4, 2, 3, 2},
//								{2, 1, 2, 4},
//								{1, 2, 3, 1},
//								{4, 1, 4, 3}
//							};

		/**반례*/
		int[][] board		= {	{1, 1, 1, 1},
								{1, 1, 1, 1},
								{1, 1, 1, 1},
								{1, 1, 1, 1}
							};

		
		/**DFS로 풀어볼 것.*/
		int result 			= solution(board);
		
		System.out.println(result);
	}//end main()
	
	
	public static int solution(int[][] board) {
        int max = -1;
         
        for(int a = 0 ; a < board.length ; a++) {
        	for(int b = 0 ; b < board[a].length ; b++) {
        		//좌표 지점마다 반복
        		int gigun = board[0][0];
        		Queue<Coordinate> queue = new LinkedList<Coordinate>();
        		queue.add(new Coordinate(0, 0, 1));
        		int[][] pattern			= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        		
        		boolean[][] visited 	= new boolean[board.length][board[0].length];
                visited[0][0] 			= true;
                
                while(!queue.isEmpty()) {
                	
                	Coordinate coordinate = queue.poll();
                	int x = coordinate.x;
                	int y = coordinate.y;
                	int distance = coordinate.distance;
                	
                	System.out.println(" ============== ");
                	for(int q = 0 ; q < pattern.length ; q++) {
                		int moveX = pattern[q][0] + x;
                		int moveY = pattern[q][1] + y;
                		
                		if(moveX < 0 || moveY < 0 || board.length -1 < moveX || board[0].length -1 < moveY) continue;
                		if(visited[moveX][moveY]) continue;
                		if(board[moveX][moveY] != gigun) continue;
                		
                		visited[moveX][moveY] = true;
                		queue.add(new Coordinate(moveX, moveY, distance + 1));
                		int dis = distance + 1;
                		if(max < dis) max = dis;
                		System.out.println(moveX + "\t" + moveY + "\t" + dis);
                	}//end for()
                }//end while()
                
        	}//end for()
        }//end for()
        
        return max;
	}//end solution()

}//end class()

class Coordinate {
	int x;
	int y;
	int distance;
	
	public Coordinate(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

}