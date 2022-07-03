package codingtest.programmers.level3;

import java.util.Arrays;

public class Dev_Matching_2022상반기_2 {
	
	public static void main(String[] args) {
		
		
		int[][] result	= solution(4, true);
		
	}//end main()

    public static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        
        //방향 꺽을 때마다 카운트
        int repeat = 1;
        
        //각 칸 마다 넣을 번호
        int number = 1;
        answer[0][0] = number;
        
        while(n != (repeat - 1)) {
        	int x = 0;
            int y = 0;
        	System.out.println(repeat + " =====================");
        	
        	int limit = (repeat * 2) + 1;
        	
        	for(int a = 0 ; a < limit ; a++) {
        		
        		
        		if(repeat % 2 == 0) {
        			x = repeat;
        			
        			System.out.println(x + ", " + y);
        			
        			if(x != repeat) x++;
        			if(x == repeat) y++;
        			
        		} else {
        			y = repeat;
        			
        			if(x == repeat) y--;
        			if((y == repeat) && (x < repeat)) x++;
        			
        			System.out.println(x + ", " + y);
        		}
        		
        		
        		number++;
        		answer[x][y] = number;
        	}//end for()
        	
        	repeat++;
        }//end for()
         
        return answer;
    }//end solution()

}//end class()