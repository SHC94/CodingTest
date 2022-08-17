package codingtest.self.st11;

import java.util.Arrays;

public class Task1 {

	public static void main(String[] args) {
		
		int N		= 28;
		int result 	= solution(N);
		
		System.out.println("result = " + result);
	}

	private static int solution(int N) {
		int answer				= N;
		int sumDigits 			= 0;
		int compareSumDigits 	= 0;
		String number 			= String.valueOf(N);
		String compareNumber 	= "";
		
		for(int a = 0 ; a < number.length() ; a++) {
			sumDigits += Character.getNumericValue(number.charAt(a));
		}//end for()
		
		while(true) {
			compareSumDigits 	= 0;
			answer++;
			compareNumber 	= String.valueOf(answer);
			
			for(int a = 0 ; a < compareNumber.length() ; a++) {
				compareSumDigits += Character.getNumericValue(compareNumber.charAt(a));
			}//end for()
			
			if(sumDigits == compareSumDigits) break;
		}//end while()
		
		return answer;
    }//end solution()
	
}//end class()
