package codingtest.baekjoon.반복문;

import java.util.Scanner;

public class 영수증 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int total 	= sc.nextInt();
		int N 		= sc.nextInt();
		int sum 	= 0;
		
		for(int a = 0 ; a < N ; a++) {
			int amount = sc.nextInt();
			int count = sc.nextInt();
			
			sum += (amount * count);
		}
		
		if(total == sum) System.out.println("Yes");
		else System.out.println("No");
		
    }

}
