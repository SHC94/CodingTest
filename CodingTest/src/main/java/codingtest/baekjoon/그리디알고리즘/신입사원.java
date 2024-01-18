package codingtest.baekjoon.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb 	= new StringBuilder();
		StringTokenizer st;
		int tc 				= Integer.parseInt(br.readLine());
		
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a - 1] = b;
			}//end for()
			int count = 1;
			int rating = arr[0];
			for (int i = 1; i < n; i++) {
				if (rating > arr[i]) {
					count++;
					rating = arr[i];
				}//end if()
			}//end for()
			sb.append(count + "\n");
		}//end while()
		System.out.println(sb.toString());
	}//end main()

}//end class()