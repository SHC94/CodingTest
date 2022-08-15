package codingtest.baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 바이러스 {

	private static int[][] arr;
	private static boolean[] visited;
	private static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int node = sc.nextInt();
		int line = sc.nextInt();

		arr = new int[node + 1][node + 1];

		for (int i = 0; i < line; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}//end for()

		visited = new boolean[node + 1];
		System.out.println(dfs(1));
	}//end main()

	private static int dfs(int start) {
		visited[start] = true;
		answer.add(start);

		if (start == arr.length) {
			return answer.size() - 1;
		}//end if()
		
		for (int j = 1; j < arr.length; j++) {
			if (arr[start][j] == 1 && visited[j] == false) {
				dfs(j);
			}//end if()
		}//end for()
		
		return answer.size() - 1;
	}//end dfs()

}// end class()
