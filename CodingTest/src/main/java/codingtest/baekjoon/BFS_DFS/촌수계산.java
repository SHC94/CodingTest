package codingtest.baekjoon.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {

	private static int count = -1;
	private static int[][] map;
	private static boolean[] isChecked = new boolean[101];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		int p 				= Integer.parseInt(br.readLine());
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		int start 			= Integer.parseInt(st.nextToken());
		int end 			= Integer.parseInt(st.nextToken());
		int r 				= Integer.parseInt(br.readLine());

		map = new int[101][101];

		for (int i = 0; i < r; i++) {
			st 				= new StringTokenizer(br.readLine());
			int one 		= Integer.parseInt(st.nextToken());
			int two 		= Integer.parseInt(st.nextToken());
			map[one][two] 	= 1;
			map[two][one] 	= 1;
		}//end for()

		dfs(start, end, 0);

		System.out.println(count);

	}//end main()

	private static void dfs(int now, int end, int move) {
		if (now == end) {
			count = move;
			return;
		}//end if()

		isChecked[now] = true;

		for (int i = 1; i <= 100; i++) {
			if (map[now][i] == 1 && !isChecked[i]) {
				dfs(i, end, move + 1);
			}//end if()
		}//end for()

	}//end dfs()
	
}//end class()