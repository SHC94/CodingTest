package codingtest.baekjoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택2 {

	private static Stack<Integer> stack = new Stack<>();
	private static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		String N 			= br.readLine();
		
		for(int a = 0 ; a < Integer.parseInt(N) ; a++) {
			
			String oper 		= br.readLine();
			int element1		= 0;
			int element2		= 0; 
			
			if(oper.length() == 1) {
				element1 = Integer.parseInt(oper);
			} else {
				StringTokenizer st	= new StringTokenizer(oper);
				element1 = Integer.parseInt(st.nextToken());
				element2 = Integer.parseInt(st.nextToken());
			}
			
			stackOperater(element1, element2);
			
		}
		
		System.out.println(result.toString());
		
	}

	private static void stackOperater(int element1, int element2) {		
		switch (element1) {
		case 1:
			stack.push(element2);
			break;
		case 2:
			if(stack.size() != 0) result.append(stack.pop()).append("\n");
			else result.append("-1").append("\n");
			break;
		case 3:
			result.append(stack.size()).append("\n");
			break;
		case 4:
			if(stack.isEmpty()) result.append("1").append("\n");
			else result.append("0").append("\n");
			break;
		case 5:
			if(stack.isEmpty()) result.append("-1").append("\n");
			else result.append(stack.peek()).append("\n");
			break;
		default:
			break;
		}
	}

}
