package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 최소공배수2 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		long child1		= sc.nextLong();
		long parent1	= sc.nextLong();
		long child2		= sc.nextLong();
		long parent2	= sc.nextLong();
		
		long parent = parent2 * parent1 / euclid(parent2, parent1);
		long child = (child1 * (parent / parent1)) + (child2 * (parent / parent2));
		
		while(true) {
			
			long pass = euclid(child, parent);
			if(pass == 1) {
				break;
			} else {
				child = child / pass;
				parent = parent / pass;
			}
		}
		
		System.out.println(child + " " + parent);
		
	}

	private static long euclid(long a, long b) {
		while(true) {
			if(a % b == 0 ) return b;
			long r = a % b;
			a = b;
			b = r;
		}
	}


}
