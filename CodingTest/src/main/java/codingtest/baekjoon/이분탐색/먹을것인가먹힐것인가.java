package codingtest.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {

	public static void main(String[] args) throws Exception {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb 	= new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int a = 0; a < T; a++) {
			st 		= new StringTokenizer(br.readLine());
			int n 	= Integer.parseInt(st.nextToken());
			int m 	= Integer.parseInt(st.nextToken());
			int[] A = new int[n];
			int[] B = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(B);

			int res = 0;

			for (int i = 0; i < n; i++) {
				for (int j = m - 1; j >= 0; j--) {
					if (A[i] > B[j]) {
						res += j + 1;
						break;
					}//end if()
				}//end for()
			}//end for()
			
			sb.append(res).append("\n");
		}//end for()
		
		System.out.println(sb);
	}//end main()

}//end class()