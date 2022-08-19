package codingtest.self.tmon;

public class Task2 {

	public static void main(String[] args) {

		//1인 비트 수 반환
		
		int number = 7;
		int result = resultBits(number);

		System.out.println("result = " + result);
	}

	public static int resultBits(int number){
		String numberStr = Integer.toBinaryString(number);
		
		int result = 0;
		
		for (int i = 0; i < numberStr.length(); i++) {
		
			if (numberStr.charAt(i) == '1') {
		
				result++;
		
			}//end if()
		
		}//end for()
		
		return result;
	}//end solution()

}//end class()
