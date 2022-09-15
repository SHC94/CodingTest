package codingtest.self.homeplus;

import java.util.*;

public class Task02 {
	
	public static void main(String[] args) {
		
		int n			= 1;
		int result 		= solution(n);
		
		System.out.println(result);
	}//end main()
	
	public static int solution(int N) {
        
        return func(N);
        
	}//end solution()

	private static int func(int x) {
		if(x == 1) return 1;
        if(x == 2) return 2;
        if(x <  1) return 0;

        return func(x - 1) + func(x - 2);
    }
}//end class()
