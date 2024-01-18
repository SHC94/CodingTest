package codingtest.baekjoon.동적계획법;

import java.util.Scanner;

public class 퇴사 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
        int n 		= sc.nextInt();
		int[] t 	= new int[n];
		int[] p 	= new int[n];
		int[] dp 	= new int[n+1];
		
		for(int i = 0 ; i <n ; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}//end for()
		
		for(int i = 0 ; i < n ; i++) {
			if (i + t[i] <= n) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}//end if()
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}//end for()
		System.out.println(dp[n]);
	}//end main()

}//end class()