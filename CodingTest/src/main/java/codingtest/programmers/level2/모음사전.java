package codingtest.programmers.level2;

public class 모음사전 {
	
	public static void main(String[] args) {
		

//		word	result
//		"AAAAE"	6
//		"AAAE"	10
//		"I"		1563
//		"EIO"	1189
		
		String word		= "AAAAE";
		
		int result 		= solution(word);
		
		System.out.println(result);
	}//end main()j
	
	public static int solution(String word) {
		int answer = word.length();

		String str 	= "AEIOU";
		int[] arr 	= { 781, 156, 31, 6, 1 };

		for (int i = 0; i < word.length(); i++) {
			int idx = str.indexOf(word.charAt(i));
			answer += arr[i] * idx;
			System.out.println(answer);
		}//end for()

		return answer;
	}//end solution()

}// end class()
