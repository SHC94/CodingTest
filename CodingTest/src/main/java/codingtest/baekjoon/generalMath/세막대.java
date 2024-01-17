package codingtest.baekjoon.generalMath;

import java.util.Scanner;

public class 세막대 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int a			= sc.nextInt();
		int b			= sc.nextInt();
		int c 			= sc.nextInt();
        int maxN 		= 0;
        
        if(a > b) {
            if(b > c) maxN = a;
            else maxN = (a > c) ? a : c;
        } else {
        	maxN = (b > c) ? b : c;
        }

        if(a + b + c - maxN > maxN) System.out.println(a + b + c);
        else System.out.print((a + b + c - maxN) * 2 - 1);
		
    }

}
