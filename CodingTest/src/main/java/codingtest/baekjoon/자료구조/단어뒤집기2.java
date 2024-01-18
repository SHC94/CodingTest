package codingtest.baekjoon.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기2 {

	public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		Stack<String> st 	= new Stack<>();

		String s = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < s.length(); i++) {
			String str = String.valueOf(s.charAt(i));
			if ("<".equals(str)) {
				print(st); // <를 만나면 여태껏 저장해둔 문자열 거꾸로 출력
				check = true;
				System.out.print(str);
			} else if (">".equals(str)) {
				check = false;
				System.out.print(str);
			} else if (check) {
				System.out.print(str);
			}

			else {
				if (" ".equals(str)) {
					print(st);
					System.out.print(str);
				}

				else {
					st.push(str);
				}
			}

		}

		print(st);

	}//end main()

	private static void print(Stack st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}
}//end class()
