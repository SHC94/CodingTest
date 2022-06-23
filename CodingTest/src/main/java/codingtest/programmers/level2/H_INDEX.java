package codingtest.programmers.level2;

import java.util.Arrays;

public class H_INDEX {
	
	public static void main(String[] args) {
		
//		citations		return
//		[3, 0, 6, 1, 5]	3
		
		int[] citations = {3, 0, 6, 1, 5};
		int result 		= solution(citations);
		
		System.out.println(result);
	}//end main()
	
	
	public static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int a = 0 ; a < citations.length ; a++) {
        	int n = citations.length - a;	//전체 논문 n편
        	System.out.println(n + " / " + citations[a] + "======================");
        	if(n <= citations[a]) {
        		answer = n;
        		break;
        	}//end if()
        }//end for()
        
        return answer;
	}//end solution()

}//end class()