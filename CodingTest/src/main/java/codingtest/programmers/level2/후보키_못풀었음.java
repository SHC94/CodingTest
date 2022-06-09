package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 후보키_못풀었음 {
	
	public static void main(String[] args) {
		

//		relation	
//		[["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]	
		
//		result
//		2
		
		String[][] relation	= {	{"100","ryan","music","2"},
								{"200","apeach","math","2"},
								{"300","tube","computer","3"},
								{"400","con","computer","4"},
								{"500","muzi","music","3"},
								{"600","apeach","music","2"}};
		
		 
		int result 			= solution(relation);
		
		System.out.println(result);
	}//end main()
	
	static List<String> resultList = new ArrayList<String>();   
	
	private static int solution(String[][] relation) {
        
        HashMap<String, HashSet<String>> resultMap 	= new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> arrIndexMap		= new HashMap<String, Integer>();
        
        String[] arr 		= {"학번", "이름", "전공", "학년"};
        boolean[] visited 	= new boolean[arr.length];
        
        //key에 대한 조합 추출 =======================================================================================
        for(int r = 1; r <= arr.length ; r++) {
        	
        	arrIndexMap.put(arr[r - 1], r - 1);
        	
        	combination(arr, visited, 0, arr.length, r);
        	
        }//end for()
        //key에 대한 조합 추출 =======================================================================================
        
        
        //key 조합에 따른 value 추출 =======================================================================================
        for(int a = 0 ; a < resultList.size() ; a++) {
        	
        	String keyCombi 	= resultList.get(a);
        	String[] keyArr 	= keyCombi.split(", ");
        	HashSet<String> set = new HashSet<String>();
        	
        	for(int b = 0 ; b < relation.length ; b++) {
        		
        		StringBuilder valueBuilder 	= new StringBuilder();
        		
        		for(String key : keyArr) {
        			
        			int arrIndex = arrIndexMap.get(key);
        			String value = relation[b][arrIndex];
        			valueBuilder.append(value).append("/");
        			
        		}//end for()
        		
        		set.add(valueBuilder.toString());
        	}//end for()
        	
        	String resultKey = Arrays.toString(keyArr);
        	
        	//중복 값이 없는 경우 =======================================================================================
        	if(set.size() == relation.length) {
        		boolean pass = true;
        		
        		for(String key : resultMap.keySet()) {
        			String[] stdArr 	= removeParentheses(resultKey).split(", ");
        			String[] compareArr = removeParentheses(key).split(", ");
        			
        			int cnt = 0;
        			for(int x = 0 ; x < stdArr.length ; x++) {
        				String std = stdArr[x];
        				for(int y = 0 ; y < compareArr.length ; y++) {
        					String compare = compareArr[y];
        					if(std.equals(compare)) cnt++;
        				}//end for()
        			}//end for()
        			
        			if(cnt == compareArr.length) pass = false;
        			
        		}//end for()
        		
        		if(pass) resultMap.put(resultKey, set);
        	}//end if()
        	
        }//end for()
        //key 조합에 따른 value 추출 =======================================================================================
        
        
        //값 확인
        for(String key : resultMap.keySet()) {
        	System.out.println("key = " + key + " / value = " + resultMap.get(key));
        }//end for()
        return resultMap.size();
	}//end solution()

	/**
	 * key 조합 추출1
	 */
	private static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			print(arr, visited, n);
			return;
		}//end if()
		
		for(int i = start ; i < n ; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}//end for()
	}//end conbination()

	/**
	 * key 조합 추출2
	 */
	private static void print(String[] arr, boolean[] visited, int n) {
		List<String> keyList = new ArrayList<String>();
		
		for(int i = 0 ; i < n ; i++) {
			if(visited[i]) keyList.add(arr[i]);
		}//end for()
		
		resultList.add(removeParentheses(keyList.toString()));
	}//end print()
	
	/**
	 * 괄호 제거
	 */
	public static String removeParentheses(String str) {
		String result = str.replace("[", "").replace("]", "");
		return result;
	}//end removeParentheses()
	
}//end class()