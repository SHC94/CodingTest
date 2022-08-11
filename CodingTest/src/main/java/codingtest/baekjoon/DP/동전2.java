package codingtest.baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전2 {
	private static int n, k;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st 	= new StringTokenizer(br.readLine(), " ");
		n 		= Integer.parseInt(st.nextToken());
		k 		= Integer.parseInt(st.nextToken());
		arr 	= new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}//end for()

		int[] dp = new int[k + 1];

		for (int i = 1; i <= k; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
		}//end for()
		
		for (int i = 1; i <= n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}//end for()
		}//end for()

		if (dp[k] == Integer.MAX_VALUE - 1)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}// end main()

}// end class()