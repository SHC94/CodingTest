package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 분수합 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		long A 		= sc.nextLong();
		long B 		= sc.nextLong();
		
		long min 	= euclid(A, B);
		System.out.println(A * B / min);
	}

	private static long euclid(long a, long b) {
		while(true) {
			if(a % b == 0) return b;
			long r = a % b;
			a = b;
			b = r;
		}
	}


}
