package codingtest.baekjoon.심화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 붙임성좋은총총이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		set.add("ChongChong");
		
		for(int a = 0 ; a < N ; a++) {
			String meet = br.readLine();
			StringTokenizer st = new StringTokenizer(meet);
			String person1 = st.nextToken();
			String person2 = st.nextToken();
			
			if(set.contains(person1)) set.add(person2);
			if(set.contains(person2)) set.add(person1);
		}
		
		System.out.println(set.size());
	}
}
