package codingtest.programmers.level1;

public class 삼진법뒤집기 {
	
	public static void main(String[] args) {
		
//		n	result
//		45	7
//		125	229
				
		int n		= 45;
		
		int result 	= solution(n);
		
		System.out.println(result);
	}//end main()j
	
	public static int solution(int n) {
		int answer = 0;
        
        String ans 			= Integer.toString(n,3);
		StringBuilder sb 	= new StringBuilder();
		
		for(int a = ans.length() - 1 ; 0 <= a ; a--) {
			String ansStr = String.valueOf(ans.charAt(a));
			sb.append(ansStr);
		}//end for()
		
		answer = Integer.parseInt(sb.toString(),3);
		
        return answer;
    }//end solution()

}//end class()
