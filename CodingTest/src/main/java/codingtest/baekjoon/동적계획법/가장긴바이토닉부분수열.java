package codingtest.baekjoon.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴바이토닉부분수열 {

	private static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		int n 				= Integer.parseInt(br.readLine());
		String[] spl 		= br.readLine().split(" ");
		int[] list 			= new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(spl[i]);
		}//end for()

		int[] leftlist 	= new int[n];
		int[] rightlist = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				if (list[i] > list[j]) {
					leftlist[i] = Math.max(leftlist[i], leftlist[j] + 1);
				}//end if()
			}//end for()
		}//end for()
		
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (list[i] > list[j]) {
					rightlist[i] = Math.max(rightlist[i], rightlist[j] + 1);
				}//end if()
			}//end for()
		}//end for()

		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(leftlist[i] + rightlist[i], answer);
		}//end for()
		
		System.out.println(answer + 1);

	}// end main()

}// end class()