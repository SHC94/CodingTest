package codingtest.self.toss.one;

import java.util.LinkedList;
import java.util.Queue;

public class Task2 {
	
	public static void main(String[] args) {

		//int[] levels = {1, 2, 3, 4};
		int[] levels = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	  	int result = solution(levels);
		System.out.println(result);
	}//end main()
	
	public static int solution(int[] levels) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        Double maxLevel = (double) levels[levels.length - 1];
        System.out.println(maxLevel);
        for(int a = 0 ; a < levels.length ; a++) {        	
        	System.out.println(100 - ((double)levels[a] / (double)levels.length) * 100);
        }//end for()
        
        System.out.println(queue.toString());
        
        if(queue.isEmpty()) answer = -1;
        else answer = queue.poll();
        
        return answer;
    }//end solution()

}//end class()
