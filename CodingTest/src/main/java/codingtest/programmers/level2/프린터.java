package codingtest.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	
	public static void main(String[] args) {
		
//		priorities			location	return
//		[2, 1, 3, 2]		2			1
//		[1, 1, 9, 1, 1, 1]	0			5
				
		int[] priorities	= {1, 1, 9, 1, 1, 1}; 
		int location		= 0;
				
		int result 			= solution(priorities, location);
		
		System.out.println(result);
	}//end main()
	
	public static int solution(int[] priorities, int location) {
        int answer 					= 0;
        String[] prioritiesCopy		= new String[priorities.length];
        Queue<String> prioritiesQ	= new LinkedList<>();
        Queue<String> answerQ		= new LinkedList<>();
        
        for(int a = 0 ; a < priorities.length ; a++) {
        	prioritiesQ.add(String.valueOf(priorities[a]).concat("/").concat(String.valueOf(a)));
        	prioritiesCopy[a] = String.valueOf(priorities[a]).concat("/").concat(String.valueOf(a));
        }//end for()
        
        while(true) {
        	if(prioritiesQ.size() == 0) break;

        	Arrays.sort(prioritiesCopy);
        	String[] maxArr 	= prioritiesCopy[prioritiesCopy.length - 1].split("/");
        	String[] peekArr 	= prioritiesQ.peek().split("/");
        	int max 			= Integer.parseInt(maxArr[0]);
        	int peek 			= Integer.parseInt(peekArr[0]);
        	
        	if(max > peek) {
        		prioritiesQ.add(prioritiesQ.poll());
        	} else {
        		answerQ.add(String.valueOf(prioritiesQ.poll()));
        		prioritiesCopy[prioritiesCopy.length - 1] = "-1/-1";
        	}//end if()
        	
        }//end while()
        
        while(!answerQ.isEmpty()) {
        	answer++;
        	String locationNumber = answerQ.peek().split("/")[1];
        	if(locationNumber.equals(String.valueOf(location))) break;
        	answerQ.remove();
        }//end while()
        
        return answer;
    }//end solution()

}//end class()
