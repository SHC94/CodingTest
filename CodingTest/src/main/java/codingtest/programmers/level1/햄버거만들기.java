package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 햄버거만들기 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/133502

		// 입출력 예
		// ingredient					result
		// [2, 1, 1, 2, 3, 1, 2, 3, 1]	2
		// [1, 3, 2, 1, 2, 1, 3, 1, 2]	0

		int[] ingredient	= {2, 1, 1, 2, 3, 1, 2, 3, 1};
		int result 			= solution(ingredient);
		
        System.out.println(result);
	}

	private static int solution(int[] ingredient) {
	 	// 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다
	 	// 빵 – 야채 – 고기 - 빵 >>> 1 2 3 1
	 	int[] recipe = {1, 2, 3, 1};
		int answer = 0;
		List<Integer> list = new ArrayList<>();

		for(int i : ingredient) {
			list.add(i);
			while(list.size() >= 4) {

				int n = list.size();
				if(!(list.get(n - 1) == recipe[3]
					&& list.get(n - 2) == recipe[2]
					&& list.get(n - 3) == recipe[1]
					&& list.get(n - 4) == recipe[0])) break;

				for(int j = 0 ; j < 4 ; j++) {
					list.remove(list.size() -1);
				}
				answer++;
			}
		}
        return answer;
	}

}
