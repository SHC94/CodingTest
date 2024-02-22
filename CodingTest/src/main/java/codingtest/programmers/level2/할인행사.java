package codingtest.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;

public class 할인행사 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/131127
//		입출력 예
//		want	number	discount	result
//		["banana", "apple", "rice", "pork", "pot"]
//		[3, 2, 2, 2, 1]
//		["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]
//		3

//		["apple"]
//		[10]
//		["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]
//		0

		String[] want		= {"banana", "apple", "rice", "pork", "pot"};
		int[] number 		= {3, 2, 2, 2, 1};
		String[] discount	= {"chicken", "apple", "apple", "banana", "rice"
								, "apple", "pork", "banana", "pork", "rice"
								, "pot", "banana", "apple", "banana"};


//		String[] want		= {"apple"};
//		int[] number 		= {10};
//		String[] discount	= {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

		int result 			= solution(want, number, discount);
		
		System.out.println(result);
	}//end main()

//자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
	public static int solution(String[] want, int[] number, String[] discount) {
		HashMap<String, Integer> wantMap = new HashMap<>();
		HashMap<String, Integer> compare;
		int result 		= 0;
		Boolean pass	= true;

		for(int a = 0 ; a < want.length ; a++) wantMap.put(want[a], number[a]);

		for(int a = 0 ; a < discount.length - 9 ; a++) {
			compare 		= new HashMap<>(wantMap);
			String[] period = Arrays.copyOfRange(discount, a, a + 10);
			pass			= true;

			for(int b = 0 ; b < period.length ; b++) {
				String product = period[b];
				if(compare.containsKey(product)) compare.put(product, compare.get(product) - 1);
			}

			for(String key : compare.keySet()) if(0 < compare.get(key)) pass = false;

			if(pass) result++;

		}

        return result;
    }

}
