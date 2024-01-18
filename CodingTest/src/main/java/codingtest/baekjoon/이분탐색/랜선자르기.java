package codingtest.baekjoon.이분탐색;

import java.util.Scanner;

public class 랜선자르기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K 		= sc.nextInt();	//가지고 있는 랜선의 갯수
		int N 		= sc.nextInt();	//필요한 랜선의 갯수
		
		long start 	= 0;
		long end 	= 0;
		
		int[] arr = new int[K];
		for(int a = 0 ; a < arr.length ; a++) {
			arr[a] = sc.nextInt();
			if(end < arr[a]) end = arr[a];
		}//end for()
		end++;
		
		while(start < end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			for(int a = 0 ; a < arr.length ; a++) {
				int length = arr[a];
				cnt += (length / mid);
			}//end for()
			
			if(cnt < N) {			//갯수가 모자른 경우 == 길이를 줄인다.
				end = mid;
			}else {					//갯수가 일치하는 경우
				start = mid + 1;
			}//end if()
		}//end while()
				
		System.out.println(start - 1);
	}//end main()
	
}//end class()