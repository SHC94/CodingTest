package codingtest.baekjoon.DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class 스택 {

	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		
		Stack<Integer> stack 	= new Stack<Integer>();
		StringBuilder result 	= new StringBuilder(); 
		
		for(int a = 0 ; a < N ; a++) {
			String excute = sc.next();
			
			//push X: 정수 X를 스택에 넣는 연산이다.
			if(excute.contains("push")) {
				stack.push(sc.nextInt());
			//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			} else if(excute.equals("pop")) {
				
				if(stack.isEmpty()) result.append("-1").append("\n");
				else result.append(stack.pop()).append("\n");
				
			//size: 스택에 들어있는 정수의 개수를 출력한다.
			} else if(excute.equals("size")) {
				result.append(stack.size()).append("\n");
			//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
			} else if(excute.equals("empty")) {
				
				if(stack.isEmpty()) result.append("1").append("\n");
				else result.append("0").append("\n");
				
			//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			} else if(excute.equals("top")) {
				
				if(stack.isEmpty()) result.append("-1").append("\n");
				else result.append(stack.peek()).append("\n");
				
			}//end if() 
			
		}//end for()
		
		System.out.println(result);
	}//end main()

}//end class()
