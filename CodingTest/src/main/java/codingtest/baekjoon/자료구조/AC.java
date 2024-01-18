package codingtest.baekjoon.자료구조;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AC {

	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		ArrayDeque<Integer> deque;
		StringTokenizer st;

		int T = sc.nextInt();

		while (T-- > 0) {

			String command = sc.next();
			int n = sc.nextInt();
			st = new StringTokenizer(sc.next(), "[],");

			deque = new ArrayDeque<Integer>();

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}//end for()

			AC(command, deque);
		}//end while()

		System.out.println(sb);

	}//end main()

	public static void AC(String command, ArrayDeque<Integer> deque) {

		boolean pass = true;

		for (char cmd : command.toCharArray()) {

			if (cmd == 'R') {
				pass = !pass;
				continue;
			}//end if()
			
			if (pass) {
				if (deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}//end if()
			} else {
				if (deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}//end if()
			}//end if()
		}//end for()

		print(deque, pass);

	}//end AC()

	public static void print(ArrayDeque<Integer> deque, boolean pass) {

		sb.append('[');

		if (deque.size() > 0) {

			if (pass) {

				sb.append(deque.pollFirst());

				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}//end while()
			} else { // 역방향일경우
				sb.append(deque.pollLast());

				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}//end while()
			}//end if()
		}//end if()

		sb.append(']').append('\n');
	}//end print()
}//end class()