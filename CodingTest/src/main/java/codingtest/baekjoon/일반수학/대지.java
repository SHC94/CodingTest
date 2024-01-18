package codingtest.baekjoon.일반수학;

import java.util.Scanner;

public class 대지 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		
		if(N == 1) {
			
			System.out.println(0);
			
		} else {
			
			int xMin		= Integer.MAX_VALUE;
			int xMax		= Integer.MIN_VALUE;
			int yMin		= Integer.MAX_VALUE;
			int yMax		= Integer.MIN_VALUE;
			
			for(int a = 0 ; a < N ; a++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(xMin > x) xMin = x;
				if(xMax < x) xMax = x;
				if(yMin > y) yMin = y;
				if(yMax < y) yMax = y;
			}
			int x = 0;
			int y = 0;
			
			x = xMax - xMin;
			y = yMax - yMin;
			System.out.println(x * y);
			
		}
		
    }

}
