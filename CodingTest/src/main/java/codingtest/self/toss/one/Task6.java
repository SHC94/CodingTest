package codingtest.self.toss.one;

import java.util.HashMap;

public class Task6 {
	
	public static void main(String[] args) {
		//int[] steps_one, String[] names_one, int[] steps_two, String[] names_two, int[] steps_three, String[] names_three;
	  	//solution(steps_one, names_one, steps_two, names_two, steps_three, names_three);
		
	}//end main()
	
	public static String[] solution(int[] steps_one, String[] names_one, int[] steps_two, String[] names_two, int[] steps_three, String[] names_three) {
        String[] answer = {};
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<String, HashMap<Integer,Integer>>();
        
        HashMap<String, Integer> oneMap = new HashMap<String, Integer>();
        for(int a = 0 ; a < steps_one.length ; a++) {
        	
        	String name = names_one[a];
        	int step 	= steps_one[a];
        	
        	if(oneMap.containsKey(name)) {
        		int compareStep = oneMap.get(name);
        		if(compareStep < step) oneMap.put(name, step);
        	} else {
        		oneMap.put(name, step);
        	}//end if()
        	
        }//end for()
        
        return answer;
    }//end solution()

}//end class()
