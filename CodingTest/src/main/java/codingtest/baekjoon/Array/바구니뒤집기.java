package codingtest.baekjoon.Array;

import java.util.Arrays;
import java.util.Scanner;

public class 바구니뒤집기 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		int M			= sc.nextInt();

		int[] arr 		= new int[N];

		for(int a = 0 ; a < N ; a++) arr[a] = a + 1; 
		
		for(int a = 0 ; a < M ; a++) {
			int start 		= sc.nextInt();
			int end			= sc.nextInt();
			int[] copyArr 	= Arrays.copyOfRange(arr, start - 1, end);
			int index 		= 1;
			
			for (int b = start - 1 ; b < end ; b++) {
				arr[b] = copyArr[copyArr.length - index];
				index++;
			}

		}
		
		for(int a = 0 ; a < arr.length ; a++) {
			if(a == arr.length - 1) {
				System.out.print(arr[a]);	
			} else {
				System.out.print(arr[a] + " ");
			}
		}
    }
}
