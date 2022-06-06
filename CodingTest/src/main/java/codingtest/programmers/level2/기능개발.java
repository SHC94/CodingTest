package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 기능개발 {
	
	public static void main(String[] args) {
		
//		progresses					speeds				return
//		[93, 30, 55]				[1, 30, 5]			[2, 1]
//		[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
		
		int[] progresses	= {93, 30, 55}; 
		int[] speeds		= {1, 30, 5};
		
		int[] result 		= solution(progresses, speeds);
		
		System.out.println(Arrays.toString(result));
	}//end main()j
	
	public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<>();
        int breakPoint = 0;
        
        while(true) {
        	
        	Stack<Integer> stack = new Stack<Integer>();
        	
        	//하룻동안 열심히 작업하기
        	for(int a = 0 ;a < progresses.length ; a++) {
            	int progress 	= progresses[a];
            	
            	if((progress < 100) && (progress != -1)) {
            		int speed 		= speeds[a];
                	progresses[a] 	= progress + speed;
            	}//end if()
            	
            }//end for()
        	//퇴근
        	
        	//정산
        	for(int b = 0 ; b < progresses.length ; b++) {
        		int seProgs = progresses[b];
        		
        		if((seProgs < 100) && (seProgs != -1)) {
        			break;
        		} else if(100 <= seProgs) {
        			stack.push(seProgs);
        			progresses[b] = -1;
        		}
        	}//end for()
        	
        	int stackSize = stack.size();
        	if(0 < stackSize) {
        		breakPoint += stackSize;
        		stack.clear();
        		resultList.add(stackSize);
        	}
        	
        	if(breakPoint == progresses.length) break;
        }//end while()
        
        int[] answer = new int[resultList.size()];
        
        for(int c = 0 ; c < resultList.size() ; c++) answer[c] = resultList.get(c);
        
        return answer;
    }//end solution()

}//end class()
