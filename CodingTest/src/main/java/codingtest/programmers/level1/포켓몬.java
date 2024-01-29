package codingtest.programmers.level1;

import java.util.HashSet;

public class 포켓몬 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/1845
		
		// 입출력 예
		// nums				result
		// [3,1,2,3]		2
		// [3,3,3,2,2,4]	3
		// [3,3,3,2,2,2]	2
		
		int[] nums = {3,3,3,2,2,4};
		
		int result = process(nums);
		
        System.out.println(result);
		
	}

	private static int process(int[] nums) {
		HashSet<Integer> pocketmon = new HashSet<>();
		
		for(int a = 0 ; a < nums.length ; a++)
			pocketmon.add(nums[a]);
		
		int length = nums.length / 2;
		
		return pocketmon.size() >= length ? length : pocketmon.size();
	}

}
