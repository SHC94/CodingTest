package codingtest.programmers.level2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 뉴스클러스터링 {
	
	public static void main(String[] args) {
		
//		str1		str2			answer
//		FRANCE		french			16384
//		handshake	shake hands		65536
//		aa1+aa2		AAAA12			43690
//		E=M*C^2		e=m*c^2			65536

		String str1	= "FRANCE";
		String str2	= "french";
		int result 	= solution(str1, str2);
		
		System.out.println(result);
	}//end main()
	
	static BigInteger max = new BigInteger("0");
	
	public static int solution(String str1, String str2) {
		List<String> multiSet1 		= new ArrayList<>();
		List<String> multiSet2 		= new ArrayList<>();
		List<String> union 			= new ArrayList<>();
		List<String> intersection 	= new ArrayList<>();
      
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
      
		for(int a = 0 ; a < str1.length() - 1 ; ++a){
			char first 	= str1.charAt(a);
			char second = str1.charAt(a + 1);
          
			if(first >= 'a' && first <= 'z' &&
				second >= 'a' && second <= 'z'){
				multiSet1.add(String.valueOf(first) + String.valueOf(second));
			}//end if()
		}//end for()
      
		for(int b = 0 ; b < str2.length() - 1 ; ++b){
			char first 	= str2.charAt(b);
			char second = str2.charAt(b + 1);
          
			if(first >= 'a' && first <= 'z' &&
				second >= 'a' && second <= 'z'){
				multiSet2.add(String.valueOf(first) + String.valueOf(second));
			}//end if()
		}//end for()
      
		Collections.sort(multiSet1);
		Collections.sort(multiSet2);
            
		for(String s : multiSet1){
			if(multiSet2.remove(s)){
				intersection.add(s);
			}//end if()
			union.add(s);
		}//end for()
      
		for(String s : multiSet2){
          union.add(s);
		}//end for()
      
		double jakard = 0;
      
		if(union.size() == 0) jakard = 1;
		else jakard = (double)intersection.size() / (double)union.size();
          
		return (int)(jakard * 65536);
    }
    
}//end class()
