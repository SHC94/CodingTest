package codingtest.baekjoon.조합론;

import java.util.Scanner;

public class 팩토리얼 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		
		int sum 	= 1;
		
		for(int a = N ; 0 < a ; a--) 
			sum *= a;

		System.out.println(sum);
		
	}

}
