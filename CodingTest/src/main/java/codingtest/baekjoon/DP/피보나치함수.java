package codingtest.baekjoon.DP;

import java.util.Scanner;

public class 피보나치함수 {

	private static int zero = 0;
	private static int one 	= 0;
	
	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);
		int N		= sc.nextInt();	 //N은 40보다 작거나 같은 자연수 또는 0
		
		//각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
		for(int a = 0 ; a < N ; a++) {
			int testCase = sc.nextInt();
			zero = 0;
			one = 0;
			fibonacci(testCase);
			System.out.println(zero + " " + one);
		}//end for()
		
	}//end main()

	private static void fibonacci(int n) {
		int temp 	= 0;
		int temp1 	= 0;
		int temp2	= 1;

		if(n == 0) {
			zero++;
			return;
		} else if(n == 1) {
			one++;
			return;
		} else if(n < 0) {
			return;
		} else {
			for(int i = 1 ; i < n ; i++) {
				temp = temp1 + temp2;
				temp1 = temp2;
				temp2 = temp;
			}//end for()
			zero 	= temp1;
			one 	= temp2;
		}//end if()
		
	}//end fibonacci()

}//end class()