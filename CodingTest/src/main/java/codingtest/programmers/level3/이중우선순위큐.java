package codingtest.programmers.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	
	public static void main(String[] args) {
		
//		operations					return
//		["I 16","D 1"]				[0,0]
//		["I 7","I 5","I -5","D -1"]	[7,5]
		
		String[] operations		= {"I 7","I 5","I -5","D -1"};
		int[] result 			= solution(operations);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		
        PriorityQueue<Integer> q 		= new PriorityQueue<Integer>();
        PriorityQueue<Integer> reversQ 	= new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int a = 0 ; a < operations.length ; a++) {
        	
        	String method 	= operations[a].split(" ")[0];
        	String value 	= operations[a].split(" ")[1];
        	
        	if(method.equals("I")) {
        		
        		q.add(Integer.parseInt(value));
        		reversQ.add(Integer.parseInt(value));
        		
        	} else if (!q.isEmpty()){
        		
    			int compareValue = Integer.parseInt(value);
        		
        		//최댓값
        		if(compareValue > 0) {

        			int max = reversQ.poll();
        			q.remove(max);
        			
        		//최솟값
        		} else if (compareValue < 0) {

        			int min = q.poll();
        			reversQ.remove(min);
        			
        		}//end if()
        		
        	}//end if()
        	
        }//end for()
        
        if(reversQ.size() == 0 || q.size() == 0) {
        	answer[0] = 0;
            answer[1] = 0;
        } else {
        	answer[0] = reversQ.poll();
            answer[1] = q.poll();
        }//end if()
        
        return answer;
	}//end solution()
	
}//end class()