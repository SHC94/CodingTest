package codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 불량사용자 {
	
	public static void main(String[] args) {
		
//		user_id											banned_id								result
//		["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]						2
//		["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]			2
//		["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3
		
		//이벤트 응모자 아이디 목록이 담긴 배열 user_id
		//불량 사용자 아이디 목록이 담긴 배열 banned_id
		
		
//		String[] user_id	= {"frodo", "fradi", "crodo", "abc123", "frodoc"}; 
//		String[] banned_id	= {"fr*d*", "abc1**"};
		
//		String[] user_id	= {"frodo", "fradi", "crodo", "abc123", "frodoc"}; 
//		String[] banned_id	= {"*rodo", "*rodo", "******"};
		
		String[] user_id	= {"frodo", "fradi", "crodo", "abc123", "frodoc"}; 
		String[] banned_id	= {"fr*d*", "*rodo", "******", "******"};
		int result 			= solution(user_id, banned_id);
		
		System.out.println(result);
	}//end main()
	
	private static HashSet<HashSet<String>> result;
	private static List<List<String>> resultList; 
    
	public static int solution(String[] user_id, String[] banned_id) {
		result = new HashSet<HashSet<String>>();
        resultList = new ArrayList<List<String>>();
        
        for(int a = 0 ; a < banned_id.length ; a++) {
        	String banId 			= banned_id[a];			//밴 아이디
        	List<String> banList 	= new ArrayList<>(); 	//밴 후보 유저 담기 리스트
        	
        	//유저 목록 반복 비교
        	for(int b = 0 ; b < user_id.length ; b++) {
        		boolean equalsYN	= true;					//후보 가능 여부 파악
        		String userId 		= user_id[b];			//유저 아이디
        		if(banId.length() == userId.length()) {
        			for(int c = 0 ; c < banId.length() ; c++) {
        				String banStr 	= String.valueOf(banId.charAt(c));
        				String userStr 	= String.valueOf(userId.charAt(c));
        				
        				//마스킹 문자가 아닌데, 서로 문자가 다른 경우
        				if((!banStr.equals("*")) && (!banStr.equals(userStr))) {
        					equalsYN = false;
        					break;
        				}//end if()
        			}//end for()
        			
        		//밴 아이디와 후보 유저 아이디의 길이가 다른 경우
        		} else {
        			equalsYN = false; //후보가 될 수 없음.
        		}//end if()
        		
        		if(equalsYN) banList.add(userId);
        	}//end for()
        	resultList.add(banList);
        }//end for()
        
        //조합 찾기
        dfs(new HashSet<String>(), 0);
        System.out.println("result = " + result.toString());
        return result.size();
	}//end solution()
	
	private static void dfs(HashSet<String> distinct, int depth) {
		if (depth == resultList.size()) {
			result.add(new HashSet<>(distinct));
			return;
		}//end if()

		for (String userId : resultList.get(depth)) {
			if (!distinct.contains(userId)) {
				distinct.add(userId);
				dfs(distinct, depth + 1);
				distinct.remove(userId);
			}//end if()
		}//end for()
	}//end dfs()
	
}//end class()