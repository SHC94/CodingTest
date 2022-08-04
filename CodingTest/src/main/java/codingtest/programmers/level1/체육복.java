package codingtest.programmers.level1;

import java.util.Arrays;

public class 체육복 {
	
	public static void main(String[] args) {
		
//		n	lost		reserve		return
//		5	[2, 4]		[1, 3, 5]	5
//		5	[2, 4]		[3]			4
//		3	[3]			[1]			2
				
		int n			= 5;
		int[] lost 		= {2, 4};
		int[] reserve	= {1, 3, 5};
		
		int result = solution(n, lost, reserve);
		
		System.out.println(result);
	}//end main()j

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}//end if()
			}//end for()
		}//end for()
		
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
					answer++;
					reserve[j] = -1;
					break;
				}//end if()
			}//end for()
		}//end for()
		
		return answer;
	}//end solution()
	
}// end class()
