package codingtest.baekjoon.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {

	private static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		int n 				= Integer.parseInt(br.readLine());
		int[] map 			= new int[n + 1];
		int[] dp 			= new int[n + 1];
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}//end for()

		int result = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (map[i] < map[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}//end for()
			result = Math.max(result, dp[i]);
		}//end for()

		System.out.println(result);
	}//end main()

}// end class()