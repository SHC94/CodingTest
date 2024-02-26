package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/154539
//		입출력 예
//		numbers				result
//		[2, 3, 3, 5]		[3, 5, 5, -1]
//		[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]															25

		int[] numbers			= {9, 1, 5, 3, 6, 2};
		int[] result			= solution(numbers);
//		List<Integer> result	= solution(numbers);
		System.out.println(Arrays.toString(result));
//		System.out.println(result.toString());
	}//end main()

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);

		Stack<Integer> stack = new Stack<>();

		for (int a = 0; a < numbers.length ; a++) {
			while (!stack.isEmpty() && numbers[a] > numbers[stack.peek()]) {
				int pop = stack.pop();
				answer[pop] = numbers[a];
			}

			stack.push(a);
		}

		return answer;
    }

	public static List<Integer> solution2(int[] numbers) {
		List<Integer> list = new ArrayList<>();

		for(int a = 0 ; a < numbers.length ; a++) {
			int start 		= numbers[a];
			int maxNumber 	= Integer.MIN_VALUE;

			for(int b = a + 1 ; b < numbers.length ; b++) {
				int next = numbers[b];
				if(start < next) {
					maxNumber = next;
					list.add(maxNumber);
					break;
				}
			}
			if(maxNumber == Integer.MIN_VALUE) list.add(-1);
		}

        return list;
    }

}
