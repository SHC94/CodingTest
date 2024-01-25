package codingtest.baekjoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int a = 0 ; a < T ; a++) {
			Stack<String> stack = new Stack<>();
			String parenthesis 	= br.readLine();
			
			for(int b = 0 ; b < parenthesis.length() ; b++) {
				String element = String.valueOf(parenthesis.charAt(b));
				if(element.equals("(")) {
					stack.push(element);
				} else if(element.equals(")")) {
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						stack.push(element);
						break;
					}
				} 
			}
			
			System.out.println(stack.size() == 0 ? "YES" : "NO");
		}
	}

}
