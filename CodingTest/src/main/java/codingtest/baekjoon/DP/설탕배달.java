package codingtest.baekjoon.DP;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);
		int N		= sc.nextInt();
		//(3 ≤ N ≤ 5000)
		
		if (N == 4 || N == 7)			 	System.out.println(-1);				//3, 5kg으로 나누지 못하는 경우
		else if (N % 5 == 0) 				System.out.println(N / 5);			//5kg으로 나누어 떨어지는 경우 + 가장 작은 봉지 사용
		else if (N % 5 == 1 || N % 5 == 3) 	System.out.println((N / 5) + 1);	//5의 배수 + 1, 5의 배수 + 3 == n/5 + 1
		else if (N % 5 == 2 || N % 5 == 4)	System.out.println((N / 5) + 2);	//5의 배수 + 2, 5의 배수 + 4 == n/5 + 2
		
	}//end main()

}//end class()