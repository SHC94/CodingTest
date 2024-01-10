package codingtest.baekjoon.Array;

import java.util.Scanner;

public class 과제안내신분 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int[] student 	= new int[30];
		
		for (int a = 0 ; a < 28 ; a++) {
			int n = sc.nextInt();
			student[n - 1] = 9;
		}
		
		for(int a = 0 ; a < student.length ; a++) {			
			if(student[a] != 9) System.out.println(a + 1);
		}
		
    }
}
