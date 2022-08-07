package codingtest.baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 제곱수의합 {

	private static List<Integer> numbers 	= new ArrayList<Integer>();
	private static int[] dp 				= new int[100001];

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());

		print(n);
		bw.write(dp[n] + "\n");

		bw.flush();
		bw.close();
	}//end main()

	public static void print(int n) {

		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = 100001;

			for (int j = 1; j <= (int) i / 2; j++) {

				if (j * j == i) {
					min = 1;
					break;
				} else {
					min = Math.min(min, dp[j] + dp[i - j]);
				}//end if()

			}//end for()
			dp[i] = min;
		}//end for()

		return;
	}//end print()

}// end class()