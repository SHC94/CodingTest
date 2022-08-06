package codingtest.self.toss.one;

import java.util.Arrays;

public class Task4 {
	
	public static void main(String[] args) {
		//[[1, 2], [1, 3], [3, 4], [4, 5], [4, 6], [4, 7]]
		long[][] invitationPairs = {{1, 2}, {1, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}};
	  	
		long[] result = solution(invitationPairs);
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static long[] solution(long[][] invitationPairs) {
        long[] answer = {};
        
        //(직접 초대한 사람 수 * 10 + 내가 초대한 사람이 초대한 사람 수 * 3 + 내가 초대한 사람이 초대한 사람 수 * 1)
        
        return answer;
    }//end solution()

}//end class()
