package codingtest.baekjoon.Array;

import java.util.Scanner;

public class 세로읽기 {

	public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		String[][] matrix 	= new String[5][15];
		
		for(int a = 0 ; a < matrix.length ; a++) {
			String rowStr = sc.next();
			for(int b = 0 ; b < rowStr.length() ; b++) {
				matrix[a][b] = String.valueOf(rowStr.charAt(b));
			}
		}
		
		for(int a = 0 ; a < 15 ; a++) {
			for (int b = 0 ; b < 5 ; b++) {
				if(matrix[b][a] != null) System.out.print(matrix[b][a]);
			}
		}

    }

}
