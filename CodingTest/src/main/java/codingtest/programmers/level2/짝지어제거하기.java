package codingtest.programmers.level2;

import java.util.Stack;

public class 짝지어제거하기 {
	
	public static void main(String[] args) {
		
//		s		result
//		baabaa	1
//		cdcd	0
		
		String s		= "baabaa";
		
		int result 		= solution(s);
		
		System.out.println(result);
	}//end main()j
	
	public static int solution(String s) {
        Stack<String> stack = new Stack<String>();
        
        for(int a = 0 ; a < s.length() ; a++) {
        	String str = String.valueOf(s.charAt(a));
        	
        	if(stack.isEmpty()) {
        		stack.push(str);
        	} else {
        		String peek = stack.peek();
        		
        		if(str.equals(peek)) stack.pop();
        		else stack.push(str);
        		
        	}//end if()
        }//end for()
        
        return stack.size() == 0 ? 1 : 0;
    }//end solution()

}//end class()