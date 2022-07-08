package codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 보석쇼핑_시간초과 {
	
	public static void main(String[] args) {
		
//		gems																result
//		["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
//		["AA", "AB", "AC", "AA", "AC"]										[1, 3]
//		["XYZ", "XYZ", "XYZ"]												[1, 1]
//		["ZZZ", "YYY", "NNNN", "YYY", "BBB"]								[1, 5]
		
		//String[] gems		= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] gems		= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		
		int[] result		= solution(gems);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(String[] gems) {
		//결과 (가장 짧은 구간, 먼저 시작된 구간)
        int[] answer = new int[2];
        
        //보석의 갯수
        HashSet<String> gemsSet = new HashSet<String>(Arrays.asList(gems));
        String[] distinctGems	= gemsSet.toArray(new String[0]);
        int gemsCnt				= distinctGems.length;
        
        //짧은 구간 들
        List<Integer> sectionList = new ArrayList<Integer>(); 
         
        //조회 구간 인덱스
        int index = gemsCnt;
        
        //보석 4개가 포함된 구간이 나올때까지 반복
        while(sectionList.size() == 0) {
        	System.out.println("==================================");
        	//구간 지정
        	for(int a = 0 ; a < (gems.length - index + 1); a++) {
        		HashSet<String> sectorSet = new HashSet<String>();
        		int end = a + index - 1;
        		System.out.println(a + " / " + end);
        		for(int start = a ; start <= end ; start++) {
        			sectorSet.add(gems[start]); 
        		}//end for()
        		
        		if(sectorSet.size() == gemsCnt) {
        			sectionList.add(a + 1);
        			sectionList.add(end + 1);
        			break;
        		}//end if()
        	}//end for()
        	
        	//못찾을 때마다 최소 구간부터 +1씩 증가
        	index++;
        }//end while()
        
        answer[0] = sectionList.get(0);
        answer[1] = sectionList.get(1);
        
        return answer;
	}//end solution()
	
}//end class()