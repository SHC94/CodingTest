package codingtest.baekjoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String sentence = br.readLine();
			if(".".equals(sentence)) break;
			balanceCheck(sentence);
		}
	}

	private static void balanceCheck(String sentence) {
		Stack<String> stack = new Stack<>();
		
		for(int a = 0 ; a < sentence.length() ; a++) {
			String letter = String.valueOf(sentence.charAt(a));
			if("(".equals(letter) || "[".equals(letter)) {
				stack.push(letter);
			} else if(")".equals(letter)) {
				if(stack.isEmpty()) {
					stack.push(letter);
					break;
				} else {
					if("(".equals(stack.peek())) {
						stack.pop();
					} else {
						stack.push(letter);
						break;
					}
				}
			} else if("]".equals(letter)) {
				if(stack.isEmpty()) {
					stack.push(letter);
					break;
				} else {
					if("[".equals(stack.peek())) {
						stack.pop();
					} else {
						stack.push(letter);
						break;
					}
				}
				
			}
			
		}
		
		System.out.println(stack.size() == 0 ? "yes" : "no");
	}

}
