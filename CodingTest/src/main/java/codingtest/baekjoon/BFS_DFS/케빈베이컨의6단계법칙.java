package codingtest.baekjoon.BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

	private static int arr[][];
	private static boolean visit[];
	private static int N;
	private static int result;
	private static int min_count = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st 	= new StringTokenizer(br.readLine());

		N 		= Integer.parseInt(st.nextToken());
		int M 	= Integer.parseInt(st.nextToken());
		arr 	= new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[y][x] = 1;
			arr[x][y] = 1;
		}//end for()

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			BFS(i);
		}//end for()

		System.out.println(result);
	}//end main()

	private static void BFS(int start) {
		Queue<Bacon> queue = new LinkedList<>();
		int count = 0;

		visit[start] = true;
		queue.offer(new Bacon(start, 0));

		while (!queue.isEmpty()) {
			Bacon bacon = queue.poll();
			count += bacon.value;

			for (int i = 1; i <= N; i++) {
				int num = arr[bacon.num][i];

				if (num == 1 && visit[i] == false) {
					visit[i] = true;
					queue.offer(new Bacon(i, bacon.value + 1));
				}//end if()
			}//end for()
		}//end while()

		if (min_count > count) {
			min_count = count;
			result = start;
		}//end if()

	}//end bfs()

	static class Bacon {
		int num;
		int value;

		public Bacon(int num, int value) {
			this.num = num;
			this.value = value;
		}
		
	}//end class()
	
}//end class()