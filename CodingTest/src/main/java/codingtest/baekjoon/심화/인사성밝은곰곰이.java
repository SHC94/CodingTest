package codingtest.baekjoon.심화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 인사성밝은곰곰이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		HashSet<String> nickname = new HashSet<>();
		
		for(int a = 0 ; a < N ; a++) {
			String command = br.readLine();
			
			if("ENTER".equals(command)) {
				result += nickname.size();
				nickname.clear();
			} else {
				nickname.add(command);
			}
		}
		
		result += nickname.size();
		
		System.out.println(result);
	}
}
