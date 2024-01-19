package codingtest.baekjoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 좌표정렬하기 {
	
	public static void main(String[] args) {
		Scanner sc			= new Scanner(System.in);
		int N 				= sc.nextInt();
		
		List<Integer> list1	= new ArrayList<>();
		List<Integer> list2	= new ArrayList<>();
		for(int a = 0 ; a < N ; a++) {
			list1.add(sc.nextInt());
			list2.add(sc.nextInt());
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		for(int a = 0 ; a < N ; a++) 
			System.out.println(list1.get(a) + " " + list2.get(a));
	}

}