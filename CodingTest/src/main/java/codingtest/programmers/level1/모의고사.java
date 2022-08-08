package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

	public static void main(String[] args) {

//		answers		return
//		[1,2,3,4,5]	[1]
//		[1,3,2,4,2]	[1,2,3]

		int[] answers = { 1, 2, 3, 4, 5 };
		int[] result = solution(answers);

		System.out.println(Arrays.toString(result));
	}// end main()

	public static int[] solution(int[] answers) {
		int[] answer 	= {};
		int[] person1 	= { 1, 2, 3, 4, 5 };
		int[] person2 	= { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 	= { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int answer1 	= 0;
		int	answer2 	= 0;
		int answer3 	= 0;

		for (int i = 0; i < answers.length; i++) {
			if (person1[i % person1.length] == answers[i])
				answer1++;
			if (person2[i % person2.length] == answers[i])
				answer2++;
			if (person3[i % person3.length] == answers[i])
				answer3++;
		}//end for()
		
		int max 			= Math.max(Math.max(answer1, answer2), answer3);
		List<Integer> list 	= new ArrayList<Integer>();
		
		if (max == answer1)
			list.add(1);
		if (max == answer2)
			list.add(2);
		if (max == answer3)
			list.add(3);

		answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}//end for()

		return answer;
	}//end solution()

}//end class()
