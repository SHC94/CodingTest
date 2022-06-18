package codingtest.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 튜플 {
	
	public static void main(String[] args) {
		
//		s								result
//		"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
//		"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
//		"{{20,111},{111}}"				[111, 20]
//		"{{123}}"						[123]
//		"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]

		String s 		= "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] result 	= solution(s);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(String s) {
        //1. 입력 문자 >>>>> 배열 변환
		s = s.replace("{{", "")
				.replace("}}", "")
				.replace("},{", "-");
		
		String[] arr = s.split("-");
		
		//2.map에 배열 저장,, key = length  / value = list (아무거나해도 상관없었음.)
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
        for(String str : arr) {
        	String[] sArr 		= str.split(",");
        	List<String> list 	= Arrays.asList(sArr);
        	map.put(list.size(), list);
        }//end for()

        HashSet<String> set = new HashSet<String>();
        int[] answer 		= new int[map.size()];
        int index			= 0;

        //map 반복문으로 신규 값의 경우 튜플에 추가
        for(List<String> mapList : map.values()) {
        	for(int a = 0 ; a < mapList.size() ; a++) {
        		String listStr = mapList.get(a);
        		if(!set.contains(listStr)) {
        			set.add(listStr);
        			answer[index] = Integer.parseInt(listStr);
        		}//end if()
        	}//end for()
        	index++;
        }//end for()
        
        return answer;
	}//end solution()

}//end class()
