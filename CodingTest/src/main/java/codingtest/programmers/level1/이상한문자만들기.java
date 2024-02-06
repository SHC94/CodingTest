package codingtest.programmers.level1;

public class 이상한문자만들기 {
	
	public static void main(String[] args) {

//		s	return
//		"try hello world"	"TrY HeLlO WoRlD"
				
		String s			= "try hello world";
		
		String result 	= solution(s);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static String solution(String s) {
		//각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자
		String answer 	= "";
		String[] str 	= s.split("");

		int idx = 0;
		for (int i = 0 ; i < str.length ; i++) {
			if (str[i].equals(" ")) {
				idx = 0;
			} else if (idx % 2 == 0) {
				str[i] = str[i].toUpperCase();
				idx++;
			} else if (idx % 2 != 0) {
				str[i] = str[i].toLowerCase();
				idx++;
			}
			answer += str[i];
		}
		return answer;
	}
	
}
