package codingtest.baekjoon.generalMath;

import java.util.Scanner;

public class 세탁소사장동혁 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		
		int quarter 	= 25;
		int dime 		= 10;
		int nickel 		= 5;
		int penny 		= 1;
		
		for(int a = 0 ; a < N ; a++) {
			int result1		= 0;
			int result2		= 0;
			int result3		= 0;
			int result4		= 0;
			int change 	= sc.nextInt();
			
			result1 	= change / quarter;
			int q 		= change % quarter;
			
			if(q != 0) {
				result2 	= q / dime;
				int w 		= q % dime;
				
				if(w != 0) {
					result3 	= w / nickel;
					int e 		= w % nickel;
					
					if(e != 0) {
						result4 	= e / penny;
					}
				}
			}
			
			System.out.println(result1 + " " + result2 + " " +  result3 + " " + result4);
			
		}

    }

}
