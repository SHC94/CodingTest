package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 최소공배수 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		int gcd		= 0;
		for(int q = 0 ; q < N ; q++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println("======================");
			gcd = GCD(A, B);
//			System.out.println(A * B / gcd);
		}
		
	}

	private static int GCD(int a, int b) {
		while(true) {
			System.out.println("a = " + a + " / b = " + b);
			if(a % b == 0) return b;
			int r = a % b;
			a = b;
			b = r;
		}
	}

}
