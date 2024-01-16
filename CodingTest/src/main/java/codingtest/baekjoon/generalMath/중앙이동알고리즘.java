package codingtest.baekjoon.generalMath;

import java.util.Scanner;

public class 중앙이동알고리즘 {

	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);
		int n 		= sc.nextInt();
        int square 	= 2;
        
        for (int i = 1; i <= n; i++) square = (square - 1) + square;
        
        System.out.println(square * square);
		
    }

}
