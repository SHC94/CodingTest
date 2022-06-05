package codingtest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {
	
	public static void main(String[] args) {
		
//		numbers			target	return
//		[1, 1, 1, 1, 1]	3		5
//		[4, 1, 2, 1]	4		2
		
		int[] numbers	= {1, 1, 1, 1, 1};
		int target		= 3;
		
		int result 		= solution(numbers, target);
		
		System.out.println(result);
	}//end main()j
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<qClass> queue	= new LinkedList<>();
        
        queue.add(new qClass(0, 0));
        
        while(!queue.isEmpty()) {
        	
        	qClass q = queue.poll();
        	int index 	= q.index;
        	int sum 	= q.sum;
        	
        	int[] pattern = {1, -1};
        	
        	if(index == numbers.length && sum == target) answer++;
        	
        	for(int a = 0 ; a < pattern.length ; a++) {
        		
        		if(numbers.length <= index) continue;
        		
        		int pm 		= pattern[a];
        		int number 	= numbers[index];
        		int num 	= number * pm;
        		int result	= sum + num;
        		
        		queue.add(new qClass(index + 1, result));
        		
        	}//end for()
        	
        }//end while()
        
        return answer;
    }//end solution()

}//end class()

class qClass {
	
	int index;
	int sum;
	
	public qClass(int index, int sum) {
		this.index 	= index;
		this.sum 	= sum;
	}//end qClass()
	
}//end class()