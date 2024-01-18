package codingtest.baekjoon.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드 {

	public static void main(String[] args) {
		
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		//상근이가 가지고 있는 카드
		int N = sc.nextInt();
		int[] nArr = new int[N];
		for(int a = 0 ; a < N ; a++) nArr[a] = sc.nextInt();
		Arrays.sort(nArr);
		
		//비교할 카드
		int M = sc.nextInt();
		for(int a = 0 ; a < M ; a++) {
			long key 		= sc.nextInt();
			int start		= 0;
			int end 		= nArr.length - 1;
			boolean pass	= false;
			
			while(start <= end) {
				int midIndex = (start + end) / 2;
				
				if(key < nArr[midIndex]) {				//비교수보다 중간값이 큰 경우
					end = midIndex - 1;
				} else if(nArr[midIndex] < key) {		//비교수보다 중간값이 작은 경우
					start = midIndex + 1;
				} else {
					result.append("1").append(" ");
					pass = true;
					break;
				}//end if()
			}//end while()
			
			if(!pass) result.append("0").append(" "); 
		}//end for()
		
		System.out.println(result.toString());
	}//end main()
	
}//end class()