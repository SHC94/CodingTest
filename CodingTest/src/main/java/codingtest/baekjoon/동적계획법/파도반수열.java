package codingtest.baekjoon.동적계획법;

import java.util.Scanner;

public class 파도반수열 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
        int T 		= sc.nextInt();
        long[] dp = new long[101];

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        
        for (int i = 6; i <= 100; i++) {
        	dp[i] = dp[i - 1] + dp[i - 5];
        }//end for()

        for (int i = 1; i <= T; i++) {
        	System.out.println(dp[sc.nextInt()]);
        }//end for()
            
	}//end main()

}//end class()