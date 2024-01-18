package codingtest.baekjoon.동적계획법;

import java.util.Scanner;

public class 스티커 {

	private static int dp[][]; 		//DP
	private static int cost[][]; 	//비용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();

			cost 	= new int[2][n + 1];
			dp 		= new int[2][n + 1];

			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= n; k++) {
					cost[j][k] = sc.nextInt();
				}//end for()
			}//end for()

			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];

			for (int k = 2; k <= n; k++) {
				dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + cost[0][k];
				dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + cost[1][k];
			}//end for()

			System.out.println(Math.max(dp[0][n], dp[1][n]));

		}//end for()

	}//end main()

}//end class()