package codingtest.programmers.level1;

public class 문자열나누기 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/140108

//		입출력 예
//		s	result
//		"banana"	3
//		"abracadabra"	6
//		"aaabbaccccabba"	3
		
		String s = "aaabbaccccabba";
		
		int result = solution(s);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
		
        
	}

	private static int solution(String s) {
        int answer = 0;
        
        int startCnt 	= 0;
        int diffCnt 	= 0;
        
        String start	= null;
        for(int a = 0 ; a < s.length() ; a++) {
        	if(start == null) start = String.valueOf(s.charAt(a));
        	String compare = String.valueOf(s.charAt(a));
        	
        	if(start.equals(compare)) startCnt++;
        	else diffCnt++;
        	
        	if((startCnt == diffCnt) || ((startCnt != diffCnt) && a == s.length() - 1)) {
        		answer++;
        		start = null;
        	}
        }
        return answer;
    }
	

}
