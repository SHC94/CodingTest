package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {

	public static void main(String[] args) {

//		id_list								report																k	result
//		["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
//		["con", "ryan"]						["ryan con", "ryan con", "ryan con", "ryan con"]					3	[0,0]

		String[] id_list	= {"muzi", "frodo", "apeach", "neo"}; 
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k			= 2;

		int[] result = solution(id_list, report, k);
		System.out.println(Arrays.toString(result));
	}// end main()

	public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        for(String reportInfo : reportSet){
            String reporter = reportInfo.split(" ")[0];
            String reported = reportInfo.split(" ")[1];
            
            reporterInfoMap.putIfAbsent(reporter, new HashSet<String>(){{
                add(reported);
            }});
            
            reporterInfoMap.get(reporter).add(reported);
            reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0)+1);
        }//end for()

        for (String reported : reportedCountInfoMap.keySet()){
            int reportedCount = reportedCountInfoMap.get(reported);
            if(k <= reportedCount){
                for(int i=0; i<id_list.length; i++){
                    if(reporterInfoMap.containsKey(id_list[i]) && reporterInfoMap.get(id_list[i]).contains(reported)) {
                        answer[i]++;
                    }//end if()
                }//end for()
            }//end if()
        }//end for()
        return answer;
	}//end solution()
}//end class()
