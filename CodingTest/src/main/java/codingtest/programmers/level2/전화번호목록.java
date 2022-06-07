package codingtest.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class 전화번호목록 {
	
	public static void main(String[] args) {
		
		
//		phone_book							return
//		["119", "97674223", "1195524421"]	false
//		["123","456","789"]					true
//		["12","123","1235","567","88"]		false
				
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		boolean result 		= solution(phone_book);
		
		System.out.println(result);
	}//end main()
	
	public static boolean solution(String[] phone_book) {
		HashSet<String> set = new HashSet<String>();
		
		//전화번호부 DB 만들기
		for(String phoneNum : phone_book) set.add(phoneNum);
		
		for(int i = 0 ; i < phone_book.length ; i++) {
			String stdNum = phone_book[i];
			
			for(int j = 1 ; j < stdNum.length() ; j++) {
				String compareStd = stdNum.substring(0, j);
				if(set.contains(compareStd)) {
					return false;
				}
			}//end for()
		}//end for()
		
        return true;
    }//end solution()

}//end class()