package codingtest.programmers.level1;

import java.util.HashMap;

public class 완주하지못한선수 {
	
	public static void main(String[] args) {
		
//		입출력 예
//		participant											completion									return
//		["leo", "kiki", "eden"]								["eden", "kiki"]							"leo"
//		["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//		["mislav", "stanko", "mislav", "ana"]				["stanko", "ana", "mislav"]					"mislav"
		
		String[] participant	= {"mislav", "stanko", "mislav", "ana"};	//참여
		String[] completion		= {"stanko", "ana", "mislav"};			//완주
		String result 			= solution(participant, completion);
		
		System.out.println(result);
	}//end main()j
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        
        for(int a = 0 ; a < participant.length ; a++) {
        	String key = participant[a];
        	
        	if(resultMap.containsKey(key)) {
        		int cnt = resultMap.get(key);
        		resultMap.put(key, ++cnt);
        	} else {
        		resultMap.put(key, 1);
        	}//end if()
        	
        }//end for()
        
        for(int b = 0 ; b < completion.length ; b++) {
        	String key = completion[b];
        	int value = resultMap.get(key);
        	if(value == 1) resultMap.remove(key);
        	else {
        		int cnt = resultMap.get(key);
        		resultMap.put(key, --cnt);
        	}//end if()        	
        }//end for()
        
        for(String key : resultMap.keySet()) {
        	answer = key;
        }//end for()
        return answer;
    }//end solution()

}//end class()
