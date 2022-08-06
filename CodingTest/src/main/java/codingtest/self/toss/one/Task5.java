package codingtest.self.toss.one;

import java.util.HashMap;

public class Task5 {
	
	public static void main(String[] args) {

		//int[] tasks = {1, 1, 2, 3, 3, 2, 2};
		int[] tasks = {4, 1, 1, 1, 1, 2, 3};
	  	int result = solution(tasks);
		System.out.println(result);
	}//end main()
	
	public static int solution(int[] tasks) {
		int answer = 0;
		
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int a = 0 ; a < tasks.length ; a++) {
        	int task = tasks[a];
        	if(map.containsKey(task)) {
        		map.put(task, map.get(task) + 1);
        	} else {
        		map.put(task, 1);
        	}//end if()
        }//end for()
        
        System.out.println(map.toString());
        
        for(int key : map.keySet()) {
        	//작업이 한개인 경우
        	if(map.get(key) == 1) {
        		return -1;
        	}//end if()
        	
        	int value = map.get(key);
        	
        	if(2 <= value) {
        		if(value % 2 != 0 && value % 3 != 0) return -1;
        		else if(value % 2 == 0) answer += (value / 2);
        		else if(value % 3 == 0) answer += (value / 3);
        	}//end if()
        	
        }//end for()
        
        return answer;
    }//end solution()

}//end class()
