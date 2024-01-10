package codingtest.baekjoon.Array;

import java.util.Arrays;
import java.util.Scanner;

public class 공바꾸기 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		int M			= sc.nextInt();

		int[] arr 		= new int[N];

		for(int a = 0 ; a < N ; a++) arr[a] = a + 1; 
		
		for(int a = 0 ; a < M ; a++) {
			int first 	= sc.nextInt();
			int second	= sc.nextInt();
			
			int f = arr[first - 1];
			int s = arr[second - 1];
			arr[first - 1] 	= s;
			arr[second - 1] = f; 

		}
		
		for(int a = 0 ; a < arr.length ; a++) {
			if(a == arr.length - 1) System.out.print(arr[a]);	
			else System.out.print(arr[a] + " ");
		}
    }
}
