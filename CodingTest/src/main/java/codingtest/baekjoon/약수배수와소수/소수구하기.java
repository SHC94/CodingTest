package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 소수구하기 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		int M 		= sc.nextInt();
		int N 		= sc.nextInt();
		
		for(int a = M ; a <= N ; a++) {
			int cnt = 0;
			
			if(a != 1) {
				for(int b = 2 ; b <= Math.sqrt(a) ; b++) {
					
					if(a % b == 0) {
						cnt++;
						break;
					}
				}
				
				if(cnt == 0) System.out.println(a);
			}
			
		}
	}
		

}
