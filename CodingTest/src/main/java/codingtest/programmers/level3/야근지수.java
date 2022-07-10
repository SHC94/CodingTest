package codingtest.programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
	
	public static void main(String[] args) {
		
//		works		n	result
//		[4, 3, 3]	4	12
//		[2, 1, 2]	1	6
//		[1,1]		3	0
				
		int n		= 3;
		int[] works	= {1, 1};
		long result = solution(n, works);
		
		System.out.println(result);
	}//end main()
	
	public static long solution(int n, int[] works) {
		long answer = 0;
		
		//일의 균등한 분배를 위해 우선순위 큐 사용 (일이 많은 순서대로)
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
        for(int i = 0; i < works.length; i++) queue.add(works[i]);
        
        //작업시간이 존재하는 경우
        while(0 < n) {
        	//작업량 출력
            int work = queue.poll();
            
            if(work == 0) {
            	//작업량 못줄임
            	break; 
            } else {
            	//작업량 줄이고 다시 담기
            	work -= 1;
            	n -= 1;
                queue.add(work);
            }//end if()
            
        }//end while()
        
        for(int work : queue) {
            answer += work * work;
        }//end for()
        
        return answer;
	}//end solution()
	
}//end class()