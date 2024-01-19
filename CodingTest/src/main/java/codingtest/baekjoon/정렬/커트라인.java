package codingtest.baekjoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 커트라인 {
	
	public static void main(String[] args) {
		Scanner sc			= new Scanner(System.in);
		List<Integer> list 	= new ArrayList<>();
		int N	= sc.nextInt();
		int k	= sc.nextInt();
		
		for(int a = 0 ; a < N ; a++) list.add(sc.nextInt());
		
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.println(list.get(k - 1));
	}

}