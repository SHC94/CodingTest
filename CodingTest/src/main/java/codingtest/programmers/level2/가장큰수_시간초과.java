package codingtest.programmers.level2;

import java.math.BigInteger;

public class 가장큰수_시간초과 {
	
	public static void main(String[] args) {
		
//		numbers				return
//		[6, 10, 2]			"6210"
//		[3, 30, 34, 5, 9]	"9534330"

		int[] numbers 	= {3, 30, 34, 5, 9};
		String result 	= solution(numbers);
		
		System.out.println(result);
	}//end main()
	
	static BigInteger max = new BigInteger("0");
	
	public static String solution(int[] numbers) {
        permutation(numbers, 0, numbers.length, numbers.length);
        
        return String.valueOf(max);
	}//end solution()

	private static void permutation(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
			return;
		}//end if()
		
		for(int i = depth ; i < n ; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n , r);
			swap(arr, depth, i);
		}//end for()
	}//end permutation()

	private static void print(int[] arr, int r) {
		StringBuilder result = new StringBuilder();
		
		for(int a = 0 ; a < r ; a++) result.append(arr[a]);
		
		BigInteger compareNum = new BigInteger(result.toString()); 
		
		if(max.compareTo(compareNum) == -1) max = compareNum;
	}//end print()

	private static void swap(int[] arr, int depth, int i) {
		int temp 	= arr[depth];
		arr[depth]	= arr[i];
		arr[i]		= temp;
	}//end swap()
}//end class()
