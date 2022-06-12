package codingtest.programmers.level2;

import java.util.Stack;

public class 더맵게{
	
	public static void main(String[] args) {
		
//		p				result
//		"(()())()"		"(()())()"
//		")("			"()"
//		"()))((()"		"()(())()"
		
		String p		= "(()())()";
		
		String result 	= solution(p);
		
		System.out.println(result);
	}//end main()j
	
	public static String solution(String p) {
        String answer = "";

        answer = fullProcess(p);
        
        return answer;
    }//end solution()

	private static String fullProcess(String p) {
		String processAns = "";
		
		//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p != null && !p.isEmpty()) {
        
        	//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 
        	//단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        	String u = "";
        	String v = "";
        	for(int a = 1 ; a < p.length() ; a++) {
        		boolean uBalance = false;
        		boolean vBalance = false;
        		
        		u = p.substring(0, a + 1);
        		v = p.substring(a + 1, p.length());
        		
        		uBalance = balanceChk(u);
        		
        		if(v != null && !v.isEmpty()) 	vBalance = balanceChk(v);
        		else	 						vBalance = true;
        		
        		if(uBalance && vBalance) break;
        	}//end for()
        	
        	boolean returnFirstProcess = okChk(u);
        	
        	//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        	if(returnFirstProcess) {
        		String thirdResult = fullProcess(v);
        		
        		//3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        		processAns = u.concat(thirdResult);
        		
        	//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        	} else {
        		
        		StringBuilder sb = new StringBuilder();
				//4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        		sb.append("(");
        		
				//4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        		String fourResult = fullProcess(v);
        		sb.append(fourResult);
        		
				//4-3. ')'를 다시 붙입니다. 
        		sb.append(")");
        		
				//4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        		u = u.substring(1, u.length() - 1);
        		
        		for(int a = 0 ; a < u.length() ; a++) {
        			String sssssssb = String.valueOf(u.charAt(a));
        			if("(".equals(sssssssb)) 		sb.append(")");
        			else if(")".equals(sssssssb)) 	sb.append("(");
        		}//end for()
        		
				//4-5. 생성된 문자열을 반환합니다.
        		processAns = sb.toString();
        	}//end if()
        	
        }//end if()
        
		return processAns;
	}//end fullProcess()
    
    private static boolean balanceChk(String uv) {
		boolean result 	= false;
		int balaceChk  	= 0;
		
		for(int a = 0 ; a < uv.length() ; a++) {
			String uvStr = String.valueOf(uv.charAt(a));
			
			if("(".equals(uvStr)) 		balaceChk++;
			else if(")".equals(uvStr))	balaceChk--;
			
		}//end for()
		
		if(balaceChk == 0) result = true;
		
		return result;
	}//end balanceChk()

	private static boolean okChk(String u) {
		boolean result 		= false;
		Stack<String> stack = new Stack<String>(); 
		
		for(int a = 0 ; a < u.length() ; a++) {
			String uStr = String.valueOf(u.charAt(a));
			
			if("(".equals(uStr)) stack.push(uStr);
			else if(")".equals(uStr) && !stack.isEmpty()) stack.pop();
			
		}//end for()
		
		if(stack.size() == 0) result = true;
		
		return result;
	}//end okChk()
}//end class()
