package codingtest.baekjoon.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

	private static int N, M, max;
	private static int[][] map;
	private static int[][] wall;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static ArrayList<virus> virusList;

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		virusList 			= new ArrayList<virus>();
		N 					= Integer.parseInt(st.nextToken());
		M 					= Integer.parseInt(st.nextToken());
		map 				= new int[N][M];
		max 				= 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new virus(i, j));
				}//end if()
			}//end for()
		}//end for()

		wall = copy(map);
		makeWall(0);
		System.out.println(max);
	}//end main()

	private static boolean isValid(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}//end isValid()

	private static int[][] copy(int[][] arr) {

		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}//end for()
		}//end for()
		return copy;
	}//end copy()

	private static void makeWall(int depth) {
		if (depth == 3) {
			spreadVirus();
			return;
		}//end if()

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wall[i][j] == 0) {
					wall[i][j] = 1;
					makeWall(depth + 1);
					wall[i][j] = 0;
				}//end if()
			}//end for()
		}//end for()
	}//end makeWall()

	private static void spreadVirus() {

		int[][] copyArr = copy(wall);

		Queue<virus> queue = new LinkedList<virus>();
		for (int i = 0; i < virusList.size(); i++) {
			queue.offer(new virus(virusList.get(i).x, virusList.get(i).y));
		}//end for()

		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.poll().y;

			for (int k = 0; k < 4; k++) {
				int moveX = x + pattern[k][0];
				int moveY = y + pattern[k][1];

				if (isValid(moveX, moveY) && copyArr[moveX][moveY] == 0) {
					copyArr[moveX][moveY] = 2;
					queue.offer(new virus(moveX, moveY));
				}//end if()

			}//end for()
		}//end while()

		int cnt = countSafe(copyArr);
		max = Math.max(max, cnt);
	}//end spreadVirus()

	private static int countSafe(int[][] copyArr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyArr[i][j] == 0) {
					cnt++;
				}//end if()
			}//end for()
		}//end for()
		return cnt;
	}//end countSafe()

	static class virus {
		int x;
		int y;

		public virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}//end class()
}//end class()
