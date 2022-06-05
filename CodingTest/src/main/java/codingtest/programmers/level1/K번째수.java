package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class K번째수 {
	
	public static void main(String[] args) {
		
//		record	
//		["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	
		
//		result
//		["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
				
		String[] record		= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String[] result 	= solution(record);
		
		System.out.println(Arrays.toString(result));
	}//end main()j
	
	public static String[] solution(String[] record) {
        List<String> resultList 		= new ArrayList<String>();
        HashMap<String, String> chatMap = new HashMap<String, String>();	//key : id / value : name
        
        for(int a = 0 ; a < record.length ; a++) {
        	String step = record[a];
        	String move = step.split(" ")[0];
        	String id	= step.split(" ")[1];
        	String name = "";
        	if(!"Leave".equals(move)) name = step.split(" ")[2];
        	
        	if("Enter".equals(move)) {
        		String msg = id + "/님이 들어왔습니다.";
        		resultList.add(msg);
        		chatMap.put(id, name);
        	} else if ("Leave".equals(move)) {
        		String msg = id + "/님이 나갔습니다.";
        		resultList.add(msg);
        	} else if ("Change".equals(move)) {
        		chatMap.put(id, name);
        	}//end if()
        	
        }//end for()
        
        int size 		= resultList.size();
        String[] answer = new String[size];
        
        for(int b = 0 ; b < size ; b++) {
        	String key 		= resultList.get(b).split("/")[0];
        	String method 	= resultList.get(b).split("/")[1];
        	String name 	= chatMap.get(key);
        	answer[b] = name.concat(method);
        }
        return answer;
    }//end solution()

}//end class()
