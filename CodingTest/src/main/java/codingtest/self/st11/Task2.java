package codingtest.self.st11;

import java.util.Arrays;

public class Task2 {

	public static void main(String[] args) {
		
		int[] A			= {1, 1, 2, 3, 3}; 
		int K			= 3;
		boolean result 	= solution(A, K);
		
		System.out.println("result = " + result);
	}

	private static boolean solution(int[] A, int K) {
		int n = A.length;
		
        for (int i = 0; i < n - 1; i++) {

            if (A[i] + 1 < A[i + 1]) {
            	return false;
            }//end if()
                
        }//end for()
        
        if (A[0] != K && A[n - 1] != K) {
        	return false;
        } else {
        	return true;
        }//end if()
            
	}//end solution()
	
}//end class()
