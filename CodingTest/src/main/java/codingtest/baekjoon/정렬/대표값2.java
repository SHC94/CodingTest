package codingtest.baekjoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 대표값2 {
	
	public static void main(String[] args) {
		Scanner sc			= new Scanner(System.in);
		List<Integer> list 	= new ArrayList<>();
		
		for(int a = 0 ; a < 5 ; a++) list.add(sc.nextInt());
		
		Collections.sort(list);
		
		int sum = 0;
		for(int element : list) sum += element;
		System.out.println(sum / list.size());
		System.out.println(list.get((list.size() / 2)));
	}

}