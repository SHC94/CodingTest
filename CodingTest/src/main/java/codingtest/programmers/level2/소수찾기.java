package codingtest.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	
	public static void main(String[] args) {
		

//		numbers		return
//		"17"		3
//		"011"		2
		
		String numbers	= "011";
		
		int result 		= solution(numbers);
		
		System.out.println(result);
	}//end main()
	
	static Set<Integer> resultSet = new HashSet<Integer>();   
	
	private static int solution(String numbers) {
        String[] arr = new String[numbers.length()];
        
        for(int a = 0 ; a < numbers.length() ; a++) arr[a] = String.valueOf(numbers.charAt(a));
        
        for(int r = 1 ; r <= arr.length ; r++) {
        	permutation(arr, 0, arr.length, r);
        }//end for()
        System.out.println("resultList = " + resultSet.toString());
        return resultSet.size();
	}//end solution()

	private static void permutation(String[] arr, int depth, int n, int r) {
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

	private static void print(String[] arr, int r) {
		StringBuilder sosuList = new StringBuilder();
		
		for(int i = 0 ; i < r ; i++) sosuList.append(arr[i]);

		int sosu = Integer.parseInt(sosuList.toString());
		
		boolean passFail = isPrime(sosu);
		
		if(passFail) resultSet.add(sosu);
	}//end print()

	private static boolean isPrime(int sosu) {
		
		if(sosu == 1 || sosu == 0) return false;
		
		for (int i = 2 ; i <= (int)Math.sqrt(sosu) ; i++) {
			
            if (sosu % i == 0) {
            	
               return false;
               
            }//end if()
            
         }//end for()
		
         return true;
	}//end isPrime()

	private static void swap(String[] arr, int depth, int i) {
		String temp		= arr[depth];
		arr[depth]		= arr[i];
		arr[i]			= temp;
	}//end swap()
	
}//end class()