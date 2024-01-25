package codingtest.baekjoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>(); 
		for(int a = 0 ; a < K ; a++) {
			int jaemin = Integer.parseInt(br.readLine());
			if(jaemin != 0) stack.push(jaemin);
			else stack.pop();
		}
		
		int result = 0;
		
		while(!stack.isEmpty()) 
			result += stack.pop();
		
		System.out.println(result);
		
	}

}
