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
		String[] completion		= {"stanko", "ana", "mislav"};				//완주
		String result 			= solution(participant, completion);
		
		System.out.println(result);
	}//end main()j
	
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> peopleMap = new HashMap<>();
		for(int a = 0 ; a < participant.length ; a++) {
			String people = participant[a];
			if(peopleMap.containsKey(people)) peopleMap.put(people, peopleMap.get(people) + 1);
			else peopleMap.put(people, 1);
		}
		
		for(int a = 0 ; a < completion.length ; a++) {
			String people = completion[a];
			if(peopleMap.containsKey(people)) {
				if(peopleMap.get(people) == 0) peopleMap.remove(people);
				else peopleMap.put(people, peopleMap.get(people) -1); 
			}
		}
		
		String answer = "";
		
		for(String key : peopleMap.keySet()) {
			if(peopleMap.get(key) != 0) answer = key; 
		}
        
        return answer;
    }

}
