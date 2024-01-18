package codingtest.baekjoon.백트래킹;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class N과M_1 {
	
	private static List<String> result = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];

		for(int a = 0 ; a < N ; a++) arr[a] = a + 1;
		//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
		
		permutation(arr, 0, arr.length, M);
		
		Collections.sort(result);
		for(String answer : result) {
			System.out.println(answer);
		}//end for()
	}//end main()

	private static void permutation(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
			return;
		}//end if()
       
		for(int i = depth ; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}//end for()
	}//end permutation()

	private static void print(int[] arr, int r) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
            sb.append(arr[i]).append(" ");
		}//end for()
         
		result.add(sb.toString());
	}//end permuprint()

	private static void swap(int[] arr, int depth, int i) {
		int temp	= arr[depth];
        arr[depth]	= arr[i];
        arr[i]		= temp;
	}//end swap()

}//end class()