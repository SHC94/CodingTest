package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 오픈채팅방 {
	
	public static void main(String[] args) {
		
//		array					commands							return
//		[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		
		int[] array		= {1, 5, 2, 6, 3, 7, 4};
		int[][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] result 		= solution(array, commands);
		
		System.out.println(Arrays.toString(result));
	}//end main()j
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        //2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5
        for(int a = 0 ; a < commands.length ; a++) {
        	List<Integer> sortList = new ArrayList<Integer>();
        	int i = commands[a][0];
        	int j = commands[a][1];
        	int k = commands[a][2];
        	
        	// i ~ j번째 수 뽑기
        	for(int b = i - 1 ; b <= j - 1 ; b++) sortList.add(array[b]);
        	
        	// 정렬
        	Collections.sort(sortList);
        	
        	// k 번째 수 뽑기
        	answer[a] = sortList.get(k - 1);
  
        }//end for()
        
        return answer;
    }//end solution()

}//end class()
