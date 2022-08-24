package codingtest.baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {

	private static int N;
	private static int min = Integer.MAX_VALUE;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N 		= Integer.parseInt(br.readLine());
		map 	= new int[N][N];
		visited 	= new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//end for()
		}//end for()

		dfs(0, 0);

		System.out.println(min);
	}// end main()

	private static void dfs(int depth, int a) {

		if (depth == N / 2) {
			diff();
			return;
		}//end if()

		for (int i = a; i < N; i++) {
			visited[i] = true;
			dfs(depth + 1, i + 1);
			visited[i] = false;
		}//end for()
		
	}//end dfs()

	private static void diff() {
		int start 	= 0;
		int link 	= 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				
				if (visited[i] == true && visited[j] == true) {
					start += map[i][j];
					start += map[j][i];
				} else if (visited[i] == false && visited[j] == false) {
					link += map[i][j];
					link += map[j][i];
				}//end if()

			}//end for()
		}//end for()

		int val = Math.abs(start - link);

		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}//end if()

		min = Math.min(min, val);
	}//end diff()

}//end class()