package codingtest.programmers.level2;

import java.math.BigDecimal;
import java.util.*;

public class 줄서는방법_못풀었음 {
	
	public static void main(String[] args) {
		
//		n	k	result
//		3	5	[3,1,2]

		int n	= 3;
		long k	= 5;
		
		int[] result 	= solution(n, k);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	static List<BigDecimal> resultList = new ArrayList<BigDecimal>();
	
	public static int[] solution(int n, long k) {
        int[] answer    = new int[n];
        int[] arr       = new int[n];
        
        for(int a = 0 ; a < n ; a++) arr[a] = a + 1;
        
        permutation(arr, 0, arr.length, arr.length);
        
        Collections.sort(resultList);
        
        String value = String.valueOf(resultList.get((int) (k - 1)));
        
        for(int b = 0 ; b < value.length() ; b++) answer[b] = Character.getNumericValue(value.charAt(b));
        
        return answer;
	}//end solution()

	private static void permutation(int[] arr, int depth, int n, int r){
        if(depth == r) {
            print(arr, r);
            return;
        }//end if()
        
        for(int i = depth ; i < n ; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }//end for()
    }//end permutation()
    
    private static void swap(int[] arr, int depth, int i){
        int temp    = arr[depth];
        arr[depth]  = arr[i];
        arr[i]      = temp;
    }//end swap()
    
    private static void print(int[] arr, int r) {
    	StringBuilder sb = new StringBuilder();
    	
        for(int i = 0 ; i < r ; i ++) sb.append(arr[i]);
        
        BigDecimal bd = new BigDecimal(sb.toString());
        
        resultList.add(bd);
    }//end print()
}//end class()
