package codingtest.programmers.level1;

public class 가운데글자가져오기 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/12903
		
//		s		return
//		"abcde"	"c"
//		"qwer"	"we"
		
//		String S = "abcde";
		String S = "qwer";
		
		String result = process(S);
		
        System.out.println(result);
		
	}

	private static String process(String s) {
		String result = "";
		
		if(s.length() % 2 == 0) result = s.substring((s.length() / 2) - 1 , (s.length() / 2) + 1);
		else result = s.substring((s.length() / 2) , (s.length() / 2) + 1);
		
		return result;
	}

}
