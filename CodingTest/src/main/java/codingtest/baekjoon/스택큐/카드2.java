package codingtest.baekjoon.스택큐;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int a = 1 ; a <= N ; a++) queue.add(a);
		
		while(true) {
			if(queue.size() == 1) break;
			queue.poll();
			queue.add(queue.poll()); 
		}
		
		System.out.println(queue.peek());
	}

}
