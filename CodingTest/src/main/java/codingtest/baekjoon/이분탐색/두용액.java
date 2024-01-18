package codingtest.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		int n 				= Integer.parseInt(br.readLine());
		int[] arr 			= new int[n];
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//end for()
		
		int[] answer	= new int[2];
		int start 		= 0;
		int end 		= n - 1;
		int min 		= Integer.MAX_VALUE;
		Arrays.sort(arr);
		
		while (start < end) {
			int sum = arr[start] + arr[end];

			if (min > Math.abs(sum)) {
				min = Math.abs(sum);

				answer[0] = arr[start];
				answer[1] = arr[end];

				if (sum == 0)
					break;
			}//end if()

			if (sum < 0)
				start++;
			else
				end--;
			
		}//end while()

		System.out.println(answer[0] + " " + answer[1]);
	}//end main()

}//end class()