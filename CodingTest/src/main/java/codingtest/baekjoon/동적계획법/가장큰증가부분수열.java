package codingtest.baekjoon.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장큰증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw 	= new BufferedWriter(new OutputStreamWriter(System.out));
		int N 				= Integer.parseInt(br.readLine());
		int dp[]	 		= new int[N + 1];
		int map[] 			= new int[N + 1];
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			dp[i] = map[i];
		}//end for()

		int result = dp[1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (map[j] < map[i]) {
					dp[i] = Math.max(dp[j] + map[i], dp[i]);
					result = Math.max(result, dp[i]);
				}//end if()
			}//end for()
		}//end for()
		bw.write(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
	}// end main()

}// end class()