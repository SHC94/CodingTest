package codingtest.self.coinone;

import java.util.Arrays;
import java.util.Stack;

public class Task01 {
	
	public static void main(String[] args) {
		
		
		//int[] deposit			= {500, 1000, -300, 200, -400, 100, -100};
		int[] deposit			= {500, 1000, 2000, -1000, -1500, 500};
		int[] result 			= solution(deposit);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(int[] deposit) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int a = 0 ; a < deposit.length ; a++) {
        	int money = deposit[a];
        	
        	if(0 < money) {			//입금인 경우
        		stack.push(money);
        	} else if(money < 0) {	//출금인 경우
        		int recent = stack.pop();
        		
        		if(Math.abs(money) < Math.abs(recent)) { 	//출금 금액이 최근 입금 금액보다 작은 경우
        			recent = recent + money;
        			stack.push(recent);
        		} else {									//출금 금액이 최근 입금 금액보다 큰 경우
        			while(money < 0) {
        				money = recent + money;
        				
        				if(money < 0) {
        					recent = stack.pop();	
        				}
        			}//end while()
        			
        			if(0 < money) {
        				stack.push(money);
        			}//end if()
        		}//end if()
        		
        	}//end if()
        }//end for()
        
        
        int[] answer 	= new int[stack.size()];
        int index 		= 0;
        for(int result : stack) {
        	answer[index] = result;
        	index++;
        }//end for()
        return answer;
	}//end solution()
	
}//end class()