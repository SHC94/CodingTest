package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 소수만들기 {

	public static void main(String[] args) {

//		nums	result
//		[1,2,3,4]	1
//		[1,2,7,6,4]	4

		int[] nums	= {1,2,7,6,4};
		int result 	= solution(nums);
		
		System.out.println(result);
	}// end main()

	public static int solution(int[] nums) {
		int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
        	if(i + 2 >= nums.length) break;
        	for(int j = i + 1; j < nums.length; j++) {
        		for(int h = j + 1; h < nums.length; h++) {
        			list.add(nums[i] + nums[j] + nums[h]);
        		}//end for()
        	}//end for()
        }//end for()
        
        for(int i : list) {
        	int count = 2;
        	answer++;
        	while(count < i) {
        		if(i % count == 0) {
        			answer--;
        			break;
        		}//end if()
        		count++;
        	}//end while()
        }//end for()
        return answer;
	}//end solution()
	
}//end class()
