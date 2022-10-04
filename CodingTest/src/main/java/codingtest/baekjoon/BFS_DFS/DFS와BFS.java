package codingtest.baekjoon.BFS_DFS;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {

	private static int[][] branch;
	private static boolean[] visited;
	private static Queue<Integer> queue;
	private static int N;
	private static int M;
	private static int V;
 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		branch 	= new int[1001][1001];
		visited = new boolean[1001];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			branch[a][b] = branch[b][a] = 1;
		}//end for()

		dfs(V);
		System.out.println();

		Arrays.fill(visited, false);
		bfs(V);
	}//end main()

	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= N; i++) {
			if (branch[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}//end if()
		}//end for()
	}//end dfs()

	public static void bfs(int start) {
		queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int i = 1; i < branch.length; i++) {
				if (branch[temp][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}//end if()
			}//end for()
		}//end while()
	}//end bfs()

}//end class()
