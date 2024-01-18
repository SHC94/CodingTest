package codingtest.baekjoon.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 문자열폭발 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		String origin  	= sc.next();
		String remove  	= sc.next();
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < origin.length(); i++) {
			stack.push(origin.charAt(i));

			if (stack.size() >= remove.length()) {
				boolean flag = true;
				for (int j = 0; j < remove.length(); j++) {
					if (stack.get(stack.size() - remove.length() + j) != remove.charAt(j)) {
						flag = false;
						break;                                            
					}
				}
				if (flag) {
					for (int j = 0; j < remove.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		for(char ch : stack) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}//end main()

}//end class()
