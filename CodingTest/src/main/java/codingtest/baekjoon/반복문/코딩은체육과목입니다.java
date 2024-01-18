package codingtest.baekjoon.반복문;

import java.util.Scanner;

public class 코딩은체육과목입니다 {

public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		int input 			= sc.nextInt();
		int repeat			= input / 4;
		StringBuilder result = new StringBuilder();
		
		for(int a = 0 ; a < repeat ; a++) {
			result.append("long ");
		}
		
		result.append("int");
		
		System.out.println(result.toString());
    }

}
