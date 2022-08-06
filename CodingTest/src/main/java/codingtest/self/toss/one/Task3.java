package codingtest.self.toss.one;

public class Task3 {

	public static void main(String[] args) {

		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
		int result = solution(k, dungeons);
		System.out.println(result);

	}// end main()

	private static int answer = 0;
	private static boolean[] visit;

	public static int solution(int k, int[][] dungeons) {
		visit = new boolean[dungeons.length];

		dfs(0, k, dungeons);

		return answer;
	}// end solution()

	private static void dfs(int depth, int k, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visit[i] && dungeons[i][0] <= k) {
				visit[i] = true;
				dfs(depth + 1, k - dungeons[i][1], dungeons);
				visit[i] = false;
			} // end if()
		} // end for()

		answer = Math.max(answer, depth);
	}// end dfs()
}// end class()
