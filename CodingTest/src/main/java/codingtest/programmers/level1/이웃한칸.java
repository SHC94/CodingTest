package codingtest.programmers.level1;

import java.util.*;

public class 이웃한칸 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/250125

		String[][] board	= {{"blue", "red", "orange", "red"}, 
							 	{"red", "red", "blue", "orange"}, 
								{"blue", "orange", "red", "red"}, 
								{"orange", "orange", "red", "blue"}};
		int h				= 1;
		int w				= 1;
		
//		String[][] board	= {{"yellow", "green", "blue"}, 
//								{"blue", "green", "yellow"}, 
//								{"yellow", "blue", "blue"}};
//		int h				= 0;
//		int w				= 1;

		int result 	= process(board, h, w);
		
        System.out.println(result);
	}

	private static int process(String[][] board, int h, int w) {
		int result = 0;
		int[][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		
		for(int a = 0 ; a < direction.length ; a++) {
			int x = direction[a][0];
			int y = direction[a][1];
			int moveX = h + x;
			int moveY = w + y;
			
			if(0 <= moveX && moveX <= board.length - 1 && 0 <= moveY && moveY <= board[0].length - 1) {
				if(board[h][w].equals(board[moveX][moveY])) result++;
			}
		}
		return result;
	}

}
