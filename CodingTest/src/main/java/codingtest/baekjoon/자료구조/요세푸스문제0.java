package codingtest.baekjoon.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제0 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int a = 0 ; a < N ; a++) queue.add(a + 1);
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		while(1 < queue.size()) {
			
			for(int i = 0; i < K - 1; i++) {
				int val = queue.poll();
				queue.add(val);
			}//end for()
			
			sb.append(queue.poll()).append(", ");
			
		}//end while()

		sb.append(queue.poll()).append('>');
		System.out.println(sb);
		
	}//end main()

}//end class()
