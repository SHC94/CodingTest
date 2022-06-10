package codingtest.coupang;

import java.util.*;

public class SCM_Back_end_Engineer_in_2022_2 {
	
	public static void main(String[] args) {
		
		Long n = 6L;

		long[] result 		= solution(n);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static long[] solution(long n) {
        long[] answer = new long[2];
        List<Long> list = new ArrayList<Long>();
        
        for(int i = 1 ; i * i <= n ; i++){
        	
        	if(n % i == 0) {
        		Long x = (long) i;
        		Long y = (long) (n / i);
        		
        		if(x != y && isPrime(x, y)) {
        			list.add(x);
        			list.add(y);
        			break;
        		}//end if()
        		
        	}//end if()
        }//end for()
        
        if(list.isEmpty()) {
        	Arrays.fill(answer, -1);
        } else {
        	answer[0] = list.get(0);
			answer[1] = list.get(1);
        	Arrays.sort(answer);
        }
        
        return answer;
	}//end solution()

	private static boolean isPrime(Long x, Long y) {
		
		if(x == 1 || x == 0) return false;
		if(y == 1 || y == 0) return false;
		
		for (int i = 2 ; i <= (int)Math.sqrt(x) ; i++) {
            if (x % i == 0) {
               return false;
            }//end if()
        }//end for()

		for (int i = 2 ; i <= (int)Math.sqrt(y) ; i++) {
            if (y % i == 0) {
               return false;
            }//end if()
        }//end for()
		
         return true;
	}//end isPrime()

}//end class()
