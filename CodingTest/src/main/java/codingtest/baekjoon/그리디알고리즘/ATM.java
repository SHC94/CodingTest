package codingtest.baekjoon.그리디알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		int total = 0;
		int wait = 0;

		for (int i = 0; i < N; i++) {
			wait += arr[i];
			total += wait;
		}//end for()
		
		System.out.println(total);
	}// end main()

}// end class()
