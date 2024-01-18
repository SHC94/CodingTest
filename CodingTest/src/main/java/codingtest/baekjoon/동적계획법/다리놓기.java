package codingtest.baekjoon.동적계획법;

import java.util.Scanner;

public class 다리놓기 {

	private static int[][] dp = new int[30][30];

	public static void main(String[] args) {

		Scanner sc 	= new Scanner(System.in);
		int T 		= sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			result.append(combination(M, N)).append('\n');
		}//end for()

		System.out.println(result);

	}//end main()

	static int combination(int n, int r) {
		if (dp[n][r] > 0) return dp[n][r];
		if (n == r || r == 0) return dp[n][r] = 1;

		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}//end combination()

}//end class()