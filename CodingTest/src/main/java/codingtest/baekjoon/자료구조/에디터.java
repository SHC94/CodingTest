package codingtest.baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw 	= new BufferedWriter(new OutputStreamWriter(System.out));
		String str 			= br.readLine();
		int M 				= Integer.parseInt(br.readLine());
		Stack<String> left 	= new Stack<String>();
		Stack<String> right = new Stack<String>();
		String[] arr 		= str.split("");
		
		for (String s : arr) {
			left.push(s);
		}//end for()

		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			
			switch (c) {
				case 'L':
					if (!left.isEmpty())
						right.push(left.pop());
	
					break;
				case 'D':
					if (!right.isEmpty())
						left.push(right.pop());
	
					break;
				case 'B':
					if (!left.isEmpty()) {
						left.pop();
					}
					break;
				case 'P':
					char t = command.charAt(2);
					left.push(String.valueOf(t));
	
					break;
				default:
					break;
			}//end switch()
		}//end for()

		while (!left.isEmpty()) right.push(left.pop());

		while (!right.isEmpty()) bw.write(right.pop());

		bw.flush();
		bw.close();
	}// end main()

}// end class()
