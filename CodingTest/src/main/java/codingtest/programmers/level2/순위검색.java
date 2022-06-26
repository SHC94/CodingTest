package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {
	
	public static void main(String[] args) {
		
//		info	
//		["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
//
//		query	
//		["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]
//				
//		result
//		[1,1,1,1,2,4]
				
		String[] info	= {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query	= {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] result 	= solution(info, query);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> infoMap = new HashMap<String, ArrayList<Integer>>();
        
        for(String i : info) {
        	String[] data 		= i.split(" ");
        	String[] languages 	= {data[0], "-"};
        	String[] jobs 		= {data[1], "-"};
        	String[] exps 		= {data[2], "-"};
        	String[] foods 		= {data[3], "-"};
        	Integer point 		= Integer.parseInt(data[4]);
        	
        	for(String language : languages)
        		for(String job : jobs)
        			for(String exp : exps)
        				for(String food : foods) {
        					String[] keyData 	= {language, job, exp, food};
        					String key 			= String.join(" ", keyData);
        					ArrayList<Integer> arr = infoMap.getOrDefault(key, new ArrayList<Integer>());
        					arr.add(point);
        					
        					infoMap.put(key, arr);
        				}//end for()
        
        }//end for()
        
        for(ArrayList<Integer> arr : infoMap.values()) Collections.sort(arr);
        
        int[] answer 	= new int[query.length];
        int index		= 0;
        
        for(String q : query) {
    		String[] data 	= q.split(" and ");
    		int target 		= Integer.parseInt(data[3].split(" ")[1]);
    		data[3] 		= data[3].split(" ")[0];
    		String key 		= String.join(" ", data);
    		
    		if(infoMap.containsKey(key)) {
    			ArrayList<Integer> list = infoMap.get(key);
    			int start 	= 0;
    			int end 	= list.size();
    			
    			while(start < end) {
    				int mid = (end + start) / 2;
    				
    				if(list.get(mid) >= target) {
    					end = mid;
    				} else {    			
    					start = mid + 1;
    				}
    			}//end while()
    			
    			answer[index] = list.size() - start;
    			
    		}//end if()
    		index++;
    	}//end for()
        
        return answer;
	}//end solution()

}//end class()
