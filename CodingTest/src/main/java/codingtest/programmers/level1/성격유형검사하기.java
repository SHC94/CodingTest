package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 성격유형검사하기 {
	
	public static void main(String[] args) {

		// https://school.programmers.co.kr/learn/courses/30/lessons/118666
//		입출력 예
//		survey							choices				result
//		["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]		"TCMA"
//		["TR", "RT", "TR"]				[7, 1, 3]			"RCJA"

//		지표 번호		성격 유형
//		1번 지표		라이언형(R), 튜브형(T)
//		2번 지표		콘형(C), 프로도형(F)
//		3번 지표		제이지형(J), 무지형(M)
//		4번 지표		어피치형(A), 네오형(N)
		
//		choices	뜻
//		1		매우 비동의	3
//		2		비동의		2
//		3		약간 비동의	1
//		4		모르겠음		0
//		5		약간 동의		1
//		6		동의			2
//		7		매우 동의		3
		
//		String[] survey	= {"AN", "CF", "MJ", "RT", "NA"}; 
//		int[] choices	= {5, 3, 2, 7, 5};
		String[] survey	= {"TR", "RT", "TR"}; 
		int[] choices	= {7, 1, 3};
		String result 	= solution(survey, choices);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
	}
	
	private static HashMap<Integer, HashMap<String, Integer>> indicators = new HashMap<>();
	private static HashMap<Integer, Integer> choicesPoint = new HashMap<>();
	
	public static String solution(String[] survey, int[] choices) {
		indicatorsSetting();
		choicesPointSetting();
		test(survey, choices);
        return result();
    }

	private static String result() {
		StringBuilder result = new StringBuilder();
		List<Integer> sortedKeys = new ArrayList<>(indicators.keySet());
        Collections.sort(sortedKeys);

        for (int key : sortedKeys) {
            Map<String, Integer> innerMap = indicators.get(key);
            String maxKey = innerMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            result.append(maxKey);
        }
		return result.toString();
	}
	
	private static void test(String[] survey, int[] choices) {
		for(int a = 0 ; a < survey.length ; a++) {
			String indicator 		= survey[a];
			String personalityKey	= "";
			int choice				= choices[a];
			int choicePoint			= choicesPoint.get(choice);
			
			if(choice < 4) 		personalityKey = String.valueOf(indicator.charAt(0));
			else if(4 < choice) personalityKey = String.valueOf(indicator.charAt(1));
			
			for(int key : indicators.keySet()) {
				HashMap<String, Integer> indicatorMap = indicators.get(key);
				for(String subKey : indicatorMap.keySet()) {
					if(personalityKey.equals(subKey)) {
						indicatorMap.put(subKey, indicatorMap.get(subKey) + choicePoint);
					}
				}
			}
		}
	}

	private static void choicesPointSetting() {
		choicesPoint.put(1, 3);
		choicesPoint.put(2, 2);
		choicesPoint.put(3, 1);
		choicesPoint.put(4, 0);
		choicesPoint.put(5, 1);
		choicesPoint.put(6, 2);
		choicesPoint.put(7, 3);
	}

	private static void indicatorsSetting() {
		String[] indicatorsArr = {"R T", "C F", "J M", "A N"};
		for(int a = 0 ; a < indicatorsArr.length ; a++) {
			String element = indicatorsArr[a];
			StringTokenizer st = new StringTokenizer(element);
			HashMap<String, Integer> personality = new HashMap<>();
			personality.put(st.nextToken(), 0);
			personality.put(st.nextToken(), 0);
			indicators.put(a + 1, personality);
		}
	}

}
