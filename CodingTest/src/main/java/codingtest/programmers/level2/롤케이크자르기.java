package codingtest.programmers.level2;

import java.util.HashSet;

public class 롤케이크자르기 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=java
//		입출력 예
//		topping						result
//		[1, 2, 1, 3, 1, 4, 1, 2]	2
//		[1, 2, 3, 1, 4]				0

		int[] topping	= {1, 2, 1, 3, 1, 4, 1, 2};
		int result 		= solution(topping);
		
		System.out.println(result);
	}//end main()

//롤케이크를 공평하게 자르는 방법의 수를 return 하도록 solution 함수를 완성해주세요.
	private static HashSet<Integer> totolSet = new HashSet<>();
	public static int solution(int[] topping) {

        HashSet<Integer> set 	= new HashSet<>();
        int answer 				= 0;

        int[] left 	= new int[topping.length];
        int[] right = new int[topping.length];

        for(int a = 0 ; a < topping.length ; a++) {
            set.add(topping[a]);
            left[a] = set.size();
        }

        set.clear();

        for(int a = topping.length - 1 ; a >= 0 ; a--) {
            set.add(topping[a]);
            right[a] = set.size();
        }

        for(int a = 0 ; a < topping.length - 1 ; a++) if(left[a] == right[a + 1]) answer++;
        return answer;
    }

}
