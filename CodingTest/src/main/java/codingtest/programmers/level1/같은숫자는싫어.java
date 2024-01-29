package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/12906
		
//		arr				answer
//		[1,1,3,3,0,1,1]	[1,3,0,1]
//		[4,4,4,3,3]		[4,3]
		
		int[] arr = {1,1,3,3,0,1,1};
		int[] result = process(arr);
		
//        System.out.println(result);
        System.out.println(Arrays.toString(result));
		
	}

	private static int[] process(int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		
		int start = arr[0];
		
		q.add(start);

		for(int a = 1 ; a < arr.length ; a++) {
			if(start != arr[a]) {
				q.add(arr[a]);
				start = arr[a];
			}
		}
		
		int[] result = new int[q.size()];
		int index = 0;
		while(!q.isEmpty()) result[index++] = q.poll();
		
		return result;
	}

}
