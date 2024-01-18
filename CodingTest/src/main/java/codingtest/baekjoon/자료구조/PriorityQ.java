package codingtest.baekjoon.자료구조;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQ {
	
	public static void main(String[] args) {
		
		System.out.println("Integer 타입으로 우선순위 큐 ( 낮은 순 )");
		PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
		queue1.add(2);
		queue1.add(8);
		queue1.add(6);
		queue1.add(4);
		
		for(Integer num1 : queue1) System.out.println("q1 = " + num1);
		
		System.out.println("Integer 타입으로 우선순위 큐 ( 높은 순 )");
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		queue2.add(2);
		queue2.add(8);
		queue2.add(6);
		queue2.add(4);
		
		for(Integer num2 : queue2) System.out.println("q2 = " + num2);
		
		System.out.println("String 타입으로 우선순위 큐 ( 낮은 순 )");
		PriorityQueue<String> queue3 = new PriorityQueue<String>();
		queue3.add("a");
		queue3.add("d");
		queue3.add("c");
		queue3.add("b");
		
		for(String str1 : queue3) System.out.println("q3 = " + str1);
		
		System.out.println("String 타입으로 우선순위 큐 ( 높은 순 )");
		PriorityQueue<String> queue4 = new PriorityQueue<String>(Collections.reverseOrder());
		queue4.add("가");
		queue4.add("다");
		queue4.add("나");
		queue4.add("라");
		
		for(String str2 : queue4) System.out.println("q4 = " + str2);
		
	}//end main()
	
}//end class()

