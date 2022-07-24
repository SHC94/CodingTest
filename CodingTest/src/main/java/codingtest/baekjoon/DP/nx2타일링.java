package codingtest.baekjoon.DP;

import java.util.Scanner;

public class nx2타일링 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
        int n 		= sc.nextInt();
        int[] dp 	= new int[n+2];
        dp[1] 		= 1;
        dp[2] 		= 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }//end for()
        
        System.out.println(dp[n] % 10007);
	}//end main()

}//end class()