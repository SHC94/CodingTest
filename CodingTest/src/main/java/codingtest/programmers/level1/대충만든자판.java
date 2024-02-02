package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 대충만든자판 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/160586

//		입출력 예
//		keymap				targets			result
//		["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
//		["AA"]				["B"]			[-1]
//		["AGZ", "BSSS"]		["ASA","BGZ"]	[4, 6]
		
//		1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap
		String[] keymap		= {"ABACD", "BCEFD"};
		
//		입력하려는 문자열들이 담긴 문자열 배열 targets
		String[] targets	= {"ABCD","AABB"};
		
//		각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return
		int[] result = solution(keymap, targets);
		
//		System.out.println(result);
		System.out.println(Arrays.toString(result));
		
        
	}

	private static int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		HashMap<Character, Integer> map = new HashMap<>();

		for(int a = 0 ; a < keymap.length ; a++) {

			for(int b = 0 ; b < keymap[a].length() ; b++) {

				if(map.containsKey(keymap[a].charAt(b))) {

					int cnt = map.get(keymap[a].charAt(b));
					if(cnt > (b + 1)) map.put(keymap[a].charAt(b), b + 1);
					
				} else {
					map.put(keymap[a].charAt(b), b + 1);
				}

			}
		}

		for (int a = 0 ; a < targets.length ; a++) {
			int cnt = 0;
			for (int b = 0 ; b < targets[a].length() ; b++) {
				char alpha = (targets[a].charAt(b));
				Integer min = map.get(alpha);
				if (min != null) {
					cnt += min;
				} else {
					cnt = -1;
					break;
				}
			}
			answer[a] = cnt;
		}

        return answer;
    }
	

}
