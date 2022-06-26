package codingtest.programmers.level2;

import java.util.Stack;

public class 괄호회전하기 {
	
	public static void main(String[] args) {
		
//		s			result
//		"[](){}"	3
//		"}]()[{"	2
//		"[)(]"		0
//		"}}}"		0
				
		String s	= "[](){}";
		int result 	= solution(s);
		
		System.out.println(result);
	}//end main()
	
	public static int solution(String s) {
        int answer = 0;
        
        for(int a = 0 ; a < s.length() ; a++) {
        	Stack<String> stack = new Stack<String>();
        	
        	String pre 	= s.substring(0, a);
        	String post = s.substring(a, s.length());
        	String newString = post.concat(pre);
        	
        	for(int b = 0 ; b < newString.length() ; b++) {
        		String sChar = String.valueOf(newString.charAt(b));
        		
    			if(sChar.equals("[") 
    					|| sChar.equals("{")
    					|| sChar.equals("(")) {
    				stack.push(sChar);
    			} else {
    				
    				if(!stack.isEmpty()) {
    					
    					String peek = stack.peek();
        				
        				if(peek.equals("[") && sChar.equals("]")
        						|| peek.equals("{") && sChar.equals("}")
        						|| peek.equals("(") && sChar.equals(")")) {
        					stack.pop();
        				}//end if()
        				
    				} else {
    					stack.push(sChar);
    				}//end if() 
    				
    			}//end if()
        		
        	}//end for()
        	
        	if(stack.size() == 0) answer++;
        	
        }//end for()
        
        return answer;
	}//end solution()

}//end class()
