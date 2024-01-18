package codingtest.baekjoon.자료구조;

import java.util.LinkedList;
import java.util.Scanner;

public class 회전하는큐 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
		int count 	= 0;
		int N 		= sc.nextInt();
		int M 		= sc.nextInt();
		int[] seq 	= new int[M];
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) linkedList.offer(i);
		for (int i = 0; i < M; i++) seq[i] = sc.nextInt();

		for (int i = 0; i < M; i++) {

			int target_idx = linkedList.indexOf(seq[i]);
			int half_idx;

			if (linkedList.size() % 2 == 0) {
				half_idx = linkedList.size() / 2 - 1;
			} else {
				half_idx = linkedList.size() / 2;
			}//end if()


			if (target_idx <= half_idx) {
				
				for (int j = 0; j < target_idx; j++) {
					int temp = linkedList.pollFirst();
					linkedList.offerLast(temp);
					count++;
				}//end for()
				
			} else {

				for (int j = 0; j < linkedList.size() - target_idx; j++) {
					int temp = linkedList.pollLast();
					linkedList.offerFirst(temp);
					count++;
				}//end for()

			}//end if()
			
			linkedList.pollFirst();
		}//end for()

		System.out.println(count);
	}// end main()

}// end class()
