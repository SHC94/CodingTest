package codingtest.baekjoon.일반수학;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 약수구하기 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		int K 			= sc.nextInt();
			
		List<Integer> list = new ArrayList<>();
		
		for(int a = 1 ; a <= N ; a++) {
			int result = N % a;
			if(result == 0) list.add(a); 
		}
		
		if(list.size() < K) System.out.println("0");
		else System.out.println(list.get(K - 1));	
		
    }

}
