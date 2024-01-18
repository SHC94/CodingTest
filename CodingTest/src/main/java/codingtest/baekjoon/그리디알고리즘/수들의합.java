package codingtest.baekjoon.그리디알고리즘;

import java.util.Scanner;

public class 수들의합 {

	public static void main(String[] args) {
		int answer 	= 0;
		long sum 	= 0;
		
		Scanner sc 	= new Scanner(System.in);
		long S 		= sc.nextLong();
		
		answer = 0;
		while(true) {
			sum += answer;
			if(sum > S) break;
			answer++;
		}//end while()
		
		System.out.println(--answer);
	}//end main()

}//end class()