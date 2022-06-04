package codingtest.programmers.level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
	
	public static void main(String[] args) {
		
//		lottos					win_nums					result
//		[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]		[3, 5]
//		[0, 0, 0, 0, 0, 0]		[38, 19, 20, 40, 15, 25]	[1, 6]
//		[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]		[1, 1]
		
		
		int[] lottos	= {0, 0, 0, 0, 0, 0};
		int[] win_nums	= {38, 19, 20, 40, 15, 25};
		
		int[] result = solution(lottos, win_nums);
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int max = 0;
        int min = 0;
        
        //식별할 수 있는 번호 중 당첨 갯수 출력 (최저 갯수)
        for(int a = 0 ; a < lottos.length ; a++) {
        	int lottoNum = lottos[a];
        	if(lottoNum == 0) {
        		max++;
        	} else {
        		for(int b = 0 ; b < win_nums.length ; b++) {
            		int winNum = win_nums[b];
            		if(lottoNum == winNum) min++;
            	}//end for()
        	}//end if()
        }//end for()
        
        max = max + min;
        
        int[] answerArr = {max, min};
        for(int c = 0 ; c < answerArr.length ; c++) {
        	int passNum = answerArr[c];
        	int rank	= 0;
        	
        	switch (passNum) {
				case 6:
					rank = 1;
					break;
				case 5:
					rank = 2;
					break;
				case 4:
					rank = 3;
					break;
				case 3:
					rank = 4;
					break;
				case 2:
					rank = 5;
					break;
				default:
					rank = 6;
					break;
			}//end switch()
        	
        	answer[c] = rank;
        }//end for()
        
        return answer;
    }//end solution()
	
}//end class()
