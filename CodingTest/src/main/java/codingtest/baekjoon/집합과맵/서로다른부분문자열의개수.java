package codingtest.baekjoon.집합과맵;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class 서로다른부분문자열의개수 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		HashSet<String> set = new HashSet<>();
		
		for(int a = 0 ; a < S.length() ; a++) {
			for(int b = a + 1 ; b <= S.length() ; b++) {
				set.add(S.substring(a, b));
			}
		}
		
		System.out.println(set.size());
	}

}
