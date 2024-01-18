package codingtest.baekjoon.배열;

import java.util.Scanner;

public class 행렬덧셈 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		int M 			= sc.nextInt();
		int[][] arr1	= new int[N][M];
		int[][] arr2	= new int[N][M];
		int[][] result	= new int[N][M];
		
		intputMatrix(arr1, sc);
		intputMatrix(arr2, sc);
		resultMatrix(result, arr1, arr2);
		outputMatrix(result);

    }

	private static void outputMatrix(int[][] result) {
		for(int a = 0 ; a < result.length ; a++) {
			
			for(int b = 0 ; b < result[0].length ; b++) {
				if(b == result[0].length - 1) System.out.print(result[a][b]);
				else System.out.print(result[a][b] + " "); 
			}
			
			if(a != result.length - 1) System.out.println(); 
			
		}
	}

	private static void resultMatrix(int[][] result, int[][] arr1, int[][] arr2) {
		for(int a = 0 ; a < result.length ; a++) {
			for(int b = 0 ; b < result[0].length ; b++) {
				result[a][b] = arr1[a][b] + arr2[a][b]; 
			}
		}
	}

	private static void intputMatrix(int[][] matrix, Scanner sc) {
		for(int a = 0 ; a < matrix.length ; a++) {
			for(int b = 0 ; b < matrix[0].length ; b++) {
				matrix[a][b] = sc.nextInt();
			}
		}
	}
}
