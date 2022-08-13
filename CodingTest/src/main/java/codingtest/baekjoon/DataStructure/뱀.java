package codingtest.baekjoon.DataStructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 뱀 {
	
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int n, l, k;
	private static int[][] map;
	private static List<int[]> snake;

	public static void main(String[] args) {
		snake 		= new LinkedList<>();
		snake.add(new int[] { 0, 0 });

		Scanner sc 	= new Scanner(System.in);
		n 			= sc.nextInt();
		map 		= new int[n][n];
		k 			= sc.nextInt();
		
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x - 1][y - 1] = 1;
		}//end for()

		l 			= sc.nextInt();
		int[][] dir = new int[l][2];
		
		for (int i = 0; i < l; i++) {
			dir[i][0] = sc.nextInt();
			char temp = sc.next().charAt(0);
			dir[i][1] = (temp == 'L') ? -1 : 1;
		}//end for()

		int time = solution(0, 0, 0, dir);
		System.out.println(time);
	}//end main()

	private static int solution(int x, int y, int currentDir, int[][] dir) {
		int time = 0;
		int turn = 0;

		while (true) {
			time++;
			int moveX = x + pattern[currentDir][0];
			int moveY = y + pattern[currentDir][1];

			if (isFinish(moveX, moveY))
				break;

			if (map[moveX][moveY] == 2) {
				snake.add(new int[] { moveX, moveY });
			} else {
				snake.add(new int[] { moveX, moveY });
				snake.remove(0);
			}//end if()

			x = moveX;
			y = moveY;

			if ((turn < l) && (time == dir[turn][0])) {
					currentDir = nextDir(currentDir, dir[turn][1]);
					turn++;
			}//end if()
		}//end while()
		return time;
	}//end solution()

	private static int nextDir(int current, int dir) {
		int next = (current + dir) % 4;
		if (next == -1)
			next = 3;

		return next;
	}//end nextDir()

	private static boolean isFinish(int x, int y) {
        if (x == -1 || x == n || y == -1 || y == n) {
            return true;
        }//end if()
        for (int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if (s[0] == x && s[1] == y) return true;
        }//end for()
        return false;
    }//end isFinish()
}// end class()
