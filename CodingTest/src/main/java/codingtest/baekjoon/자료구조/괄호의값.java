package codingtest.baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		String line 		= br.readLine();

		Stack<Character> st = new Stack<>();
		boolean flag 		= true;
		int answer 			= 0;
		int cnt 			= 1;
		
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);
			if (cur == '(') {
				st.push(cur);
				cnt *= 2;
			} else if (cur == '[') {
				st.push(cur);
				cnt *= 3;
			} else {
				if (cur == ')') {
					if (st.isEmpty() || st.peek() != '(') {
						flag = false;
						break;
					}
					if (line.charAt(i - 1) == '(') {
						answer += cnt;
					}
					st.pop();
					cnt /= 2;
				} else if (cur == ']') {
					if (st.isEmpty() || st.peek() != '[') {
						flag = false;
						break;
					}
					if (line.charAt(i - 1) == '[') {
						answer += cnt;
					}
					st.pop();
					cnt /= 3;
				} else {
					flag = false;
					break;
				}//end if()
			}//end if()
		}//end for()
		
		if (!flag || !st.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}//end if()
		
	}//end main()

}// end class()
