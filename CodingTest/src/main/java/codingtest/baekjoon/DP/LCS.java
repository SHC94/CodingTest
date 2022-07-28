package codingtest.baekjoon.DP;

import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		char[] str1 = in.nextLine().toCharArray();
		char[] str2 = in.nextLine().toCharArray();

		int[][] dp = new int[str1.length + 1][str2.length + 1];

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}//end if()
			}//end for()
		}//end for()

		System.out.println(dp[str1.length][str2.length]);

	}//end main()

}//end class()