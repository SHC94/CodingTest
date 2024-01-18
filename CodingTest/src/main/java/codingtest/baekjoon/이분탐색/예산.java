package codingtest.baekjoon.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 예산 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//결과
		long result = 0;
		
		//지방의 수
		int N = sc.nextInt();		
		
		//요청 예산
		int[] arr = new int[N];		
		for(int a = 0 ; a < N ; a++) arr[a] = sc.nextInt();
		
		//총 예산
		long M = sc.nextLong();
		
		Arrays.sort(arr);
		
		long start 	= 0;
		long end 	= arr[arr.length - 1];
		
		while(start <= end) {
			
			long mid = (start + end) / 2;	//상한액
			long sum = 0;
			
			for(int a = 0 ; a < arr.length ; a++) {
				int request = arr[a];
				if(mid < request) sum += mid;
				else sum += request;
			}//end for()
			
			if(sum > M) {
				end = mid - 1;
			} else {
				start = mid + 1;
				result = Math.max(result, mid);
			}//end if()
			
		}//end while()
		
		System.out.println(result);
	}//end main()
	
}//end class()