package codingtest.programmers.level1;

import java.util.*;

public class 나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/12910
		
//		입출력 예
//		arr				divisor	return
//		[5, 9, 7, 10]	5		[5, 10]
//		[2, 36, 1, 3]	1		[1, 2, 3, 36]
//		[3,2,6]			0		[-1]
		
		int[] arr 		= {3,2,6};
		int divisor 	= 0;
		List<Integer> result 	= process(arr, divisor);
		
//        System.out.println(result);
        System.out.println(result.toString());
//        System.out.println(Arrays.toString(result));
		
	}

	private static List<Integer> process(int[] arr, int divisor) {
		List<Integer> result = new ArrayList<>();
		
		if(divisor != 0) {
			for(int a = 0 ; a < arr.length ; a++) 
				if(arr[a] % divisor == 0) result.add(arr[a]);
			
			if(result.size() == 0) result.add(-1);
		}
		
		Collections.sort(result);
			
		return result;
	}

}
