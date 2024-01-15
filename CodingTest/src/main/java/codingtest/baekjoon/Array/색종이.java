package codingtest.baekjoon.Array;

import java.util.Scanner;

public class 색종이 {

	public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		String[][] matrix 	= new String[100][100];
		int N 				= sc.nextInt();
		int reuslt			= 0 ;
		
		for(int a = 0 ; a < N ; a++) {
			int start 	= sc.nextInt();
			int end		= sc.nextInt();
			for(int b = start ; b < start + 10 ; b++) {
				for(int c = end ; c < end + 10 ; c++) {
					matrix[b][c] = "9";
				}
			}
		}
		
		for(int a = 0 ; a < matrix.length ; a++) {
			for(int b = 0 ; b < matrix[0].length ; b++) {
				if(matrix[a][b] == "9") reuslt++;
			}
		}
		
		System.out.println(reuslt);

    }

}
