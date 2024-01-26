package codingtest.baekjoon.심화;

import java.util.Arrays;
import java.util.Scanner;

public class 약수 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		int[] arr	= new int[N];
		for(int a = 0 ; a < N ; a++) arr[a] = sc.nextInt();
		
		Arrays.sort(arr);
		
		System.out.println(arr[0] * arr[arr.length - 1]);
	}
}
