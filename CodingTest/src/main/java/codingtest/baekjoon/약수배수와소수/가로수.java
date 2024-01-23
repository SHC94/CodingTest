package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 가로수 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		
		int N 		= sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int a = 0 ; a < N ; a++) list.add(sc.nextInt());
		
		Collections.sort(list);
		
		int eucild = 0;
		
		for(int a = 0 ; a < N - 1; a++) {
			int gap = list.get(a + 1) - list.get(a);
			eucild = eucild(eucild, gap);
		}
		
		int result 	= 0;
		
		int distance = list.get(list.size() - 1) - list.get(0);
		
		result = distance / eucild - list.size() + 1;
		
		System.out.println(result);
	}

	private static int eucild(int a, int b) {
		while(true) {
			if(a % b == 0) return b;
			int r = a % b;
			a = b;
			b = r;
		}
	}

}
