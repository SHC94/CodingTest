package codingtest.baekjoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 수정렬하기 {
	
	public static void main(String[] args) {
		Scanner sc			= new Scanner(System.in);
		int N 				= sc.nextInt();
		List<Integer> list 	= new ArrayList<>();
		
		for(int a = 0 ; a < N ; a++) list.add(sc.nextInt());
		
		Collections.sort(list);
		
		for(int result : list) System.out.println(result);
	}

}