package codingtest.baekjoon.브루트포스;

import java.util.Scanner;

public class 블랙잭 {
	
	private static int result = Integer.MIN_VALUE;
	private static int M	= 0;
	
	public static void main(String[] args) {
		Scanner sc	= new Scanner(System.in);
		int N	 	= sc.nextInt();
		M 			= sc.nextInt();
		int[] arr	= new int[N]; 
		
		
		for(int a = 0 ; a < N ; a++) arr[a] = (sc.nextInt());
		
		// n 개중에서 r 개를 뽑는 경우
		int n = arr.length;
		permutation(arr, 0, n, 3);
		
		System.out.println(result);
		
	}

	private static void permutation(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
		}
		
		for(int d = depth ; d < n ; d++) {
			swap(arr, depth, d);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, d);
		}
		
	}

	private static void print(int[] arr, int r) {
		int sum = 0;
		for(int a = 0 ; a < r ; a++) sum += arr[a];
		
		if(sum <= M && result <= sum) result = sum;
	}

	private static void swap(int[] arr, int depth, int d) {
		int temp 	= arr[depth];
		arr[depth] 	= arr[d];
		arr[d] 		= temp;
	}

}