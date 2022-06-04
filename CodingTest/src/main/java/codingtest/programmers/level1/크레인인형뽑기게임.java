package codingtest.programmers.level1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
	
	public static void main(String[] args) {
		
//		board															moves				result
//		[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4

		//크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return
		
		int[][] board	= {	{0,0,0,0,0},
							{0,0,1,0,3},
							{0,2,5,0,1},
							{4,2,4,4,2},
							{3,5,1,3,1}};
		
		int[] moves		= {1,5,3,5,1,2,1,4};
		
		int result 		= solution(board, moves);
		System.out.println(result);
	}//end main()
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int a = 0 ; a < moves.length ; a++) {
        	//크레인이 내려갈 위치입니다.
        	int move = moves[a];
        	
        	for(int b = 0 ; b < board.length ; b++) {
        		//인형입니다.
        		int doll = board[b][move - 1];
        		
        		//0 == 빈공간이 아니면 이어서 작업을 진행합니다.
        		if(doll != 0) {
        			board[b][move - 1] = 0;
        			
        			if(!stack.isEmpty()) {		//바구니가 비어있지 않다면..
        				int peek = stack.peek();
        				
        				if(peek == doll) {		//두가지가 동일한 인형이라면
        					stack.pop();
        					answer += 2;
        				
        				} else {				//두가지가 동일하지 않다면
        					stack.push(doll);
        				}//end if()
        			
        			} else {					//바구니가 비어있다면 그냥 넣으세요.
        				stack.push(doll);
        			}//end if()
        			
        			break;
        		}//end if()
        		
        	}//end for()
        	
        }//end for()
        
        return answer;
    }//end solution()

	
}//end class()
