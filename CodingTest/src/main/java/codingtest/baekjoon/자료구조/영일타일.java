package codingtest.baekjoon.자료구조;

import java.util.Scanner;

public class 영일타일 {

	private static int[] dp = new int[1000001];;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
 
		for(int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}//end for()
		
		System.out.println(dp(N));
		
	}//end main()
	
	public static int dp(int N) {
		
		if(dp[N] == -1) dp[N] = (dp(N - 1) + dp((N - 2))) % 15746;
		
		return dp[N];
	}//end dp()
	
}//end class()
