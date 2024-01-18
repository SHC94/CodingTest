package codingtest.baekjoon.동적계획법;

import java.util.Scanner;

public class 포도주시식 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int n 		= sc.nextInt();
		int p[] 	= new int[n + 1];
		int dp[] 	= new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = sc.nextInt();
		}//end for()

		dp[1] = p[1];
		if (n > 1) dp[2] = p[1] + p[2];
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + p[i], dp[i - 3] + p[i - 1] + p[i]));
		}//end for()

		System.out.println(dp[n]);
	}//end main()

}//end class()