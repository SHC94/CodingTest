package codingtest.baekjoon.Eratosthenes;

import java.util.Arrays;
import java.util.Scanner;

public class 에라토스테네스의체 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] primeNum = new boolean[N + 1];

		int count = 0;

		/* 배열 초기화 = 처음엔 모두 소수로 보고 true 값 셋팅 */
		for (int i = 2; i <= N; i++) {
			primeNum[i] = true;
		}//end for()

		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				
				if(!primeNum[j]) continue;
				
				primeNum[j] = false;
				count++;
				
				if (count == K) {
					System.out.println(j);
					System.exit(0);
				}//end if()
				
			}//end for()
		}//end for()
	}//end main()
	
}//end class()
