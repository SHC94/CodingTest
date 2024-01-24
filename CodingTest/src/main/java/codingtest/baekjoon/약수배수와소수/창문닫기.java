package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 창문닫기 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);		
		int N 		= sc.nextInt();		
		System.out.println((int)Math.floor(Math.sqrt(N)));
	}

}
