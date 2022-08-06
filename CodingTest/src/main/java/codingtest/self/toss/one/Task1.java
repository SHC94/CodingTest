package codingtest.self.toss.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Task1 {
	
	public static void main(String[] args) {

		String s = "111999333";
	  	int result = solution(s);
		System.out.println(result);
	}//end main()
	
	public static int solution(String s) {
        HashSet<String> set = new HashSet<String>();
		int answer 			= -1;
        String temp 		= null;
        
		for (int a = 0; a < s.length(); a++) {
			String standardStr = String.valueOf(s.charAt(a));

			if(temp == null) {
				temp = standardStr;
			} else {
				
				if (temp.contains(standardStr)) {
					temp = temp.concat(standardStr);
					set.add(temp);
				} else {
					temp = standardStr;
				}//end if()

			}//end if()

		}//end for()
		
		if(!set.isEmpty()) {
			ArrayList<String> resultList = new ArrayList<>(set);
			Collections.sort(resultList, Collections.reverseOrder());
			answer = Integer.parseInt(resultList.get(0));
		}//end if()
        return answer;
    }//end solution()

}//end class()
