package codingtest.baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동 {

	private static int n, l, r;
	private static int[][] map;
	private static boolean[][] visited;
	private static List<Node> list;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}//end for()
		}//end for()

		System.out.println(move());
	}//end main()

	private static int move() {
		int result = 0;
		
		while (true) {
			boolean isMove = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}//end if()
					}//end if()
				}//end for()
			}//end for()
			if (!isMove) return result;
			
			result++;
		}//end while()
	}//end move()

	private static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();

		q.offer(new Node(x, y));
		list.add(new Node(x, y));
		visited[x][y] = true;

		int sum = map[x][y];
		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int moveX = current.x + pattern[i][0];
				int moveY = current.y + pattern[i][1];
				if (moveX >= 0 && moveY >= 0 && moveX < n && moveY < n && !visited[moveX][moveY]) {
					int diff = Math.abs(map[current.x][current.y] - map[moveX][moveY]);
					if (l <= diff && diff <= r) {
						q.offer(new Node(moveX, moveY));
						list.add(new Node(moveX, moveY));
						sum += map[moveX][moveY];
						visited[moveX][moveY] = true;
					}//end if()
				}//end if()
			}//end for()
		}//end while()
		return sum;
	}//end bfs()

	private static void changePopulation(int sum) {
		int avg = sum / list.size();
		for (Node n : list) {
			map[n.x][n.y] = avg;
		}//end for()
	}//end changePopulation()

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}// end class()