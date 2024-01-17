package codingtest.baekjoon.generalMath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 약수들의합 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		
		while(true) {
			int N = sc.nextInt();
			if(N == -1) break;
			
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			for(int a = 1 ; a < N ; a++) {
				if(N % a == 0) {
					list.add(a);
					sum += a;
				}
			}
				
			if(sum == N) {
				StringBuilder result = new StringBuilder();
				result.append(N + " = ");
				
				for (int a = 0 ; a < list.size() ; a++) {
					int value = list.get(a);
					if(a == list.size() - 1) result.append(value);
					else result.append(value + " + ");
				}
				
				System.out.println(result.toString());
				
			} else {
				
				System.out.println(N + " is NOT perfect.");
				
			}
			
			
		}
		
    }

}
