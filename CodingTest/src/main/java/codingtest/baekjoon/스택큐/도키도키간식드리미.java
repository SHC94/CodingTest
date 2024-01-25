package codingtest.baekjoon.스택큐;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 도키도키간식드리미 {

	public static void main(String[] args) throws IOException {
		Scanner sc 		= new Scanner(System.in);
		int N 			= sc.nextInt();
		String result	= "Sad";
		int turn		= 1;
		
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int a = 0 ; a < N ; a++) queue.add(sc.nextInt());
		
		while(true) {

			if(queue.isEmpty() && stack.isEmpty()) {
				result = "Nice";
				break;
			}
			
			int qPeek = queue.isEmpty() ? 0 : queue.peek();
			int sPeek = stack.isEmpty() ? 0 : stack.peek();
			
			if(qPeek != 0 && qPeek == turn) {
				queue.poll();
				turn++;
			} else if(sPeek != 0 && sPeek == turn){
				stack.pop();
				turn++;
			} else if(qPeek != turn && !queue.isEmpty()) {
				stack.push(queue.poll());
			} else {
				break;
			}
			
		}
		
		System.out.println(result);
		
	}

}
