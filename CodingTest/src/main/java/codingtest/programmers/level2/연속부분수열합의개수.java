package codingtest.programmers.level2;

import java.util.HashSet;

public class 연속부분수열합의개수 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/131701
//		입출력 예
//		elements	result
//		[7,9,1,1,4]	18

		int[] elements		= {7,9,1,1,4};
		int result 			= solution(elements);
		
		System.out.println(result);
	}

	public static int solution(int[] elements) {
		HashSet<Integer> set = new HashSet<>();

        int start = 1;

        while (start <= elements.length) {
            for (int a = 0 ; a < elements.length ; a++) {
                int value = 0;
                for (int b = a ; b < a + start ; b++) value += elements[b % elements.length];
                set.add(value);
            }
            start++;
        }

        return set.size();
    }


}
