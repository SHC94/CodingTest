package codingtest.programmers.level1;

public class 둘만의암호 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/155652

//		s		skip	index	result
//		"aukks"	"wbqd"	5		"happy"
				
		String s	= "aukks";
		String skip	= "wbqd";
		int index	= 5;
		
//		System.out.println(s.contains("a"));
		
		String result = solution(s, skip, index);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
		
        
	}

	private static String solution(String s, String skip, int index) {
		StringBuilder result = new StringBuilder();

		for (int a = 0 ; a < s.length() ; a++) {
			
			char word = s.charAt(a);
			
			for (int b = 0 ; b < index ; b++) {
				word += 1;
				if ('z' < word) word = 97;
				if (skip.contains(String.valueOf(word))) b--;
			}
			result.append(word);
		}

		return result.toString();
    }

}
