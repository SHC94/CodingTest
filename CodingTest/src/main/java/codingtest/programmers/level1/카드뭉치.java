package codingtest.programmers.level1;

public class 카드뭉치 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/159994

//		cards1	cards2	goal	result
//		["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
//		["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"
				
		String[] cards1	= {"i", "water", "drink"}; 
		String[] cards2 = {"want", "to"};
		String[] goal	= {"i", "want", "to", "drink", "water"};
		
		String result = solution(cards1, cards2, goal);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
		
        
	}

	private static String solution(String[] cards1, String[] cards2, String[] goal) {
		
		int idx1 = 0;
        int idx2 = 0;
        
        for (String word : goal) {
            if (idx1 < cards1.length && word.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
                idx2++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }

}
