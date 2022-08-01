package codingtest.baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {

	private static int N, M;
	private static int[][] map;
	private static ArrayList<Point> person;
	private static ArrayList<Point> chicken;
	private static int ans;
	private static boolean[] open;

	public static void main(String[] args) throws Exception {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw 	= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st 	= new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map 	= new int[N][N];
		person 	= new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					person.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}//end if()
			}//end for()
		}//end for()

		ans 	= Integer.MAX_VALUE;
		open 	= new boolean[chicken.size()];

		dfs(0, 0);
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}//end main()

	public static void dfs(int start, int cnt) {
		if (cnt == M) {
			int res = 0;

			for (int i = 0; i < person.size(); i++) {
				int temp = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (open[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(j).x)
								+ Math.abs(person.get(i).y - chicken.get(j).y);

						temp = Math.min(temp, distance);
					}//end if()
				}//end for()
				res += temp;
			}//end for()
			ans = Math.min(ans, res);
			return;
		}//end if()

		for (int i = start; i < chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, cnt + 1);
			open[i] = false;
		}//end for()
	}//end dfs()

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}//end class()
}// end class()