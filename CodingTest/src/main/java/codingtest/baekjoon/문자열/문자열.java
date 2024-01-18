package codingtest.baekjoon.문자열;

import java.util.Scanner;

public class 문자열 {

	public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		int N				= sc.nextInt();
		String[] resultArr 	= new String[N];
		
		for(int a = 0 ; a < N ; a++) {
			String newLine 	= sc.next();
			String fisrt 	= newLine.substring(0, 1);
			String last 	= newLine.substring(newLine.length() - 1, newLine.length());
			resultArr[a] 	= fisrt.concat(last);
		}
		
		for(String result : resultArr) {
			System.out.println(result);
		}
		
    }

}
