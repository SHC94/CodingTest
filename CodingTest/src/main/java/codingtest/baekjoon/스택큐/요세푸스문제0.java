package codingtest.baekjoon.스택큐;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		int K 		= sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder result = new StringBuilder();
		
		for(int a = 1 ; a <= N ; a++) queue.add(a);
		
		int cnt = 0;
		
		result.append("<");
		while(!queue.isEmpty()) {
			cnt++;
			if(cnt == K) {
				int a = queue.poll();
				
				if(queue.isEmpty()) result.append(a);
				else result.append(a).append(", ");
				
				cnt = 0;
			} else {
				queue.add(queue.poll());
			}
		}
		result.append(">");
		
		System.out.println(result.toString());
	}

}
