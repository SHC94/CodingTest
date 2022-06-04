package codingtest.programmers.level1;

public class 숫자문자열과영단어 {
	
	public static void main(String[] args) {
		
//		replace와 replaceAll의 차이점
//		replace(CharSequnce target, CharSequence replacement)
//		replaceAll(String regex, String replacement)
//		첫번째 인자에 문자열을 넣느냐, 정규식을 넣느냐의 차이.
		
		String str = "aaabbbccccabcddddabcdeeee";
		String result1 = str.replace("abc", "왕");
		String result2 = str.replaceAll("[abc]", "왕");
		System.out.println("replace result->"+ result1);
	  	System.out.println("replaceAll result->"+ result2);
	  	
//		s					result
//		"one4seveneight"	1478
//		"23four5six7"		234567
//		"2three45sixseven"	234567
//		"123"				123
		
		String s	= "one4seveneight"; 
		
		int result 	= solution(s);
		System.out.println(result);
	}//end main()
	
	public static int solution(String s) {
        String ansStr	= s.replaceAll("zero", "0")
			        		.replaceAll("one"  	,"1")
			        		.replaceAll("two"  	,"2")
			        		.replaceAll("three"	,"3")
			        		.replaceAll("four" 	,"4")
			        		.replaceAll("five" 	,"5")
			        		.replaceAll("six"  	,"6")
			        		.replaceAll("seven"	,"7")
			        		.replaceAll("eight"	,"8")
			        		.replaceAll("nine" 	,"9");
        			
        return Integer.parseInt(ansStr);
    }//end solution()
	
}//end class()
