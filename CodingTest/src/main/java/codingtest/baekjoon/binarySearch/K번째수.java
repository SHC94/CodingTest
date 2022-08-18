package codingtest.baekjoon.binarySearch;

import java.util.Scanner;

public class K번째수 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int n 		= sc.nextInt();
		int k 		= sc.nextInt();
		int start 	= 1;
		int end 	= k;
		int result 	= 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			long count = 0;

			for (int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}//end for()

			if (count < k) {
				start = mid + 1;
			} else {
				end = mid - 1;
				result = mid;
			}//end if()
		}//end while()
		
		System.out.println(result);
	
	}//end main()

}//end class()