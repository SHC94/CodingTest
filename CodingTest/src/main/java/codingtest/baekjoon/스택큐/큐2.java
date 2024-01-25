package codingtest.baekjoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 큐2 {

	private static ArrayDeque<Integer> queue = new ArrayDeque<>();
	private static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int a = 0 ; a < N ; a++) {
			String input = br.readLine();
			operation(input);
		}
		
		System.out.println(result.toString());
	}

	private static void operation(String input) {
		String[] commandArr = input.split(" ");
		
		if(commandArr.length == 1) {
			
			String command = commandArr[0];
			
			// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			if("pop".equals(command)) {
				if(queue.isEmpty()) result.append("-1").append("\n");
				else result.append(queue.poll()).append("\n");
				
			// size: 큐에 들어있는 정수의 개수를 출력한다.	
			} else if("size".equals(command)) {
				result.append(queue.size()).append("\n");
				
			// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
			} else if("empty".equals(command)) {
				if(queue.isEmpty()) result.append("1").append("\n");
				else result.append("0").append("\n");
				
			// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.	
			} else if("front".equals(command)) {
				if(queue.isEmpty()) result.append("-1").append("\n");
				else result.append(queue.peek()).append("\n");
				
			// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			} else if("back".equals(command)) {
				if(queue.isEmpty()) result.append("-1").append("\n");
				else result.append(queue.peekLast()).append("\n");
			}
			
		} else {
			// push X: 정수 X를 큐에 넣는 연산이다.
			queue.add(Integer.parseInt(commandArr[1]));	
		}	
	}

}
