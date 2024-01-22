package codingtest.baekjoon.집합과맵;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 나는야포켓몬마스터신형철 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		int M 		= sc.nextInt();
		
		HashMap<Integer, String> number = new HashMap<>();
		HashMap<String, Integer> name = new HashMap<>();
		
		for(int a = 1 ; a <= N ; a++) {
			String str = sc.next();
			number.put(a, str);
			name.put(str, a);
		}
		
		String q = sc.nextLine();
		for(int a = 0 ; a < M ; a++) {
			q = sc.nextLine();
			if(49 <= q.charAt(0) && q.charAt(0) <= 57) {
				System.out.println(number.get(Integer.parseInt(q)));
			} else {
				System.out.println(name.get(q));
			}
		}
	}

}
