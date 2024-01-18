package codingtest.baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 쇠막대기 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf 		= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw 		= new BufferedWriter(new OutputStreamWriter(System.out));
		String input 			= bf.readLine();
		Stack<Character> stack 	= new Stack<>();
		int result 				= 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.push('(');
				continue;
			}//end if()
			
			if (input.charAt(i) == ')') {
				stack.pop();

				if (input.charAt(i - 1) == '(') {
					result += stack.size();
				} else {
					result++;
				}//end if()
				
			}//end if()
		}//end for()

		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}// end main()

}// end class()
