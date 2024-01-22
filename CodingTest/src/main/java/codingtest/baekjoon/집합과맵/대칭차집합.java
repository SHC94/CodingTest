package codingtest.baekjoon.집합과맵;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class 대칭차집합 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		HashSet<Long> set = new HashSet<>();
		
		for(int a = 0 ; a < A ; a++) set.add(sc.nextLong());

		int result = set.size();
		
		for(int a = 0 ; a < B ; a++) {
			if(set.contains(sc.nextLong())) result--;
			else result++;
		}
		
		System.out.println(result);
	}

}
