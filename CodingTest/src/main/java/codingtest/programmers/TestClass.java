package codingtest.programmers;

import java.util.Arrays;

public class TestClass {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 9, 8, 7, 1, 2, 3, 4, 5};
		
		solution(arr);
		
	}//end main()

	private static void solution(int[] arr) {
		System.out.println("1 = " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("2 = " + Arrays.toString(arr));
	}//end solution()
	
}//end class()
