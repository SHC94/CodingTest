package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 압축 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/17684
//		입출력 예제
//		msg							answer
//		KAKAO						[11, 1, 27, 15]
//		TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
//		ABABABABABABABAB			[1, 2, 27, 29, 28, 31, 30]

		String msg				= "KAKAO";
		int[] result			= solution(msg);

		System.out.println(Arrays.toString(result));

	}//end main()

	public static int[] solution(String msg) {
		List<String> compression 	= new ArrayList<>();
		List<Integer> result 		= new ArrayList<>();

		for(int a = 0 ; a < 26 ; a++) compression.add(String.valueOf((char)('A' + a)));

		for(int a = 0 ; a < msg.length() ; a++) {
			for(int b = compression.size() - 1 ; b >= 0 ; b--) {
				if(msg.substring(a).startsWith(compression.get(b))) {
					a += compression.get(b).length() - 1;
					result.add(b + 1);
					if(a + 1 < msg.length()) compression.add(compression.get(b) + msg.charAt(a + 1));

					break;
				}
			}
		}

		int[] answer = new int[result.size()];

		for(int i = 0 ; i < result.size() ; i++)
			answer[i] = result.get(i);

		return answer;
	}

}
