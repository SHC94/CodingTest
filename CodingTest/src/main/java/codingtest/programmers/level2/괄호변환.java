package codingtest.programmers.level2;

import java.util.Iterator;
import java.util.PriorityQueue;

public class 괄호변환{
	
	public static void main(String[] args) {
		
//		scoville				K	return
//		[1, 2, 3, 9, 10, 12]	7	2
		
		int[] scoville		= {1, 2, 3, 9, 10, 12};
		int K				= 7;
		
		int result 			= solution(scoville, K);
		
		System.out.println(result);
	}//end main()j
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;	
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        for(int scovil : scoville) pqueue.add(scovil);
        
        while(true) {
        	answer++;
        	Boolean scovilYN 	= true;
        	if(pqueue.size() < 2) {
        		answer = -1;
        		break;
        	}//end if()
        	
        	int firstScovil 	= pqueue.poll();
            int secondScovil 	= pqueue.poll();
            int mixScovil 		= firstScovil + (secondScovil * 2);
            pqueue.add(mixScovil);
            
            Iterator<Integer> queueIter = pqueue.iterator();
            
            while(queueIter.hasNext()) {
            	if(K > queueIter.next()) {
            		scovilYN = false;
            		break;
            	}//end if()
            }//end while()
            
            if(scovilYN) break;
        }//end while()
        
        return answer;
    }//end solution()

}//end class()
