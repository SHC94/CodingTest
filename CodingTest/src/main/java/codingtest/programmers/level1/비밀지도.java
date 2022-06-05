package codingtest.programmers.level1;

import java.util.Arrays;

public class 비밀지도 {
	
	public static void main(String[] args) {
		
//		매개변수	값
//		n		5
//		arr1	[9, 20, 28, 18, 11]
//		arr2	[30, 1, 21, 17, 28]
//		출력		["#####","# # #", "### #", "# ##", "#####"]
		
//		매개변수	값
//		n		6
//		arr1	[46, 33, 33 ,22, 31, 50]
//		arr2	[27 ,56, 19, 14, 14, 10]
//		출력		["######", "### #", "## ##", " #### ", " #####", "### # "]
		
		int n			= 5; 
		int[] arr1 		= {9, 20, 28, 18, 11};
		int[] arr2		= {30, 1, 21, 17, 28};
		
		String[] result 		= solution(n, arr1, arr2);
		
		System.out.println(Arrays.toString(result));
	}//end main()j
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] result = new String[n];
        
        for(int a = 0 ; a < n ; a++) {
        	String one = blank(Integer.toString(arr1[a], 2), n);
        	String two = blank(Integer.toString(arr2[a], 2), n);

        	StringBuilder answerSB = new StringBuilder();
        	
        	for(int b = 0 ; b < n ; b++) {
        		String oneChk = String.valueOf(one.charAt(b));
        		String twoChk = String.valueOf(two.charAt(b));
        		 
        		if("1".equals(oneChk) || "1".equals(twoChk)) answerSB.append("#");
        		else answerSB.append(" ");
        	}//end for()
        	
        	result[a] = answerSB.toString();
        	
        }//end for()
        
        return result;
    }//end solution()

	private static String blank(String password, int n) {
		StringBuilder result = new StringBuilder();
		result.append(password);
		
		while(result.toString().length() < n) result.insert(0, "0");
		
		return result.toString();
	}//end blank()
}//end class()
