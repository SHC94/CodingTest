package codingtest.baekjoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 덱2 {

	private static ArrayDeque<Integer> q = new ArrayDeque<>();
	private static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int a = 0 ; a < N ; a++) {
			String input = br.readLine();
			int command1 = 0;
			int command2 = 0;
			
			if(input.length() == 1) {
				command1 = Integer.parseInt(input);
			} else {
				StringTokenizer st = new StringTokenizer(input);
				command1 = Integer.parseInt(st.nextToken());
				command2 = Integer.parseInt(st.nextToken());
			}
			
			operation(command1, command2);
		}
		
		System.out.println(result.toString());
		
	}

	private static void operation(int command1, int command2) {

//		1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
		if(command1 == 1) {
			q.addFirst(command2);
			
//		2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
		} else if (command1 == 2) {
			q.addLast(command2);
			
//		3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		} else if (command1 == 3) {
			if(!q.isEmpty()) result.append(q.pollFirst()).append("\n");
			else result.append("-1").append("\n");
			
//		4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		} else if (command1 == 4) {
			if(!q.isEmpty()) result.append(q.pollLast()).append("\n");
			else result.append("-1").append("\n");
			
//		5: 덱에 들어있는 정수의 개수를 출력한다.
		} else if (command1 == 5) {
			result.append(q.size()).append("\n");
			
//		6: 덱이 비어있으면 1, 아니면 0을 출력한다.
		} else if (command1 == 6) {
			if(!q.isEmpty()) result.append("0").append("\n");
			else result.append("1").append("\n");
			
//		7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		} else if (command1 == 7) {
			if(!q.isEmpty()) result.append(q.peekFirst()).append("\n");
			else result.append("-1").append("\n");
			
//		8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		} else if (command1 == 8) {
			if(!q.isEmpty()) result.append(q.peekLast()).append("\n");
			else result.append("-1").append("\n");
			
		}
	}

}
