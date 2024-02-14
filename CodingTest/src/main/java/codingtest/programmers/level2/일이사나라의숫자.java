package codingtest.programmers.level2;

public class 일이사나라의숫자 {
	public static void main(String[] args) {
//		https://school.programmers.co.kr/learn/courses/30/lessons/12899
//		입출력 예
//		n	result
//		1	1
//		2	2
//		3	4
//		4	11

		int n			= 4;
		String result 	= solution(n);

		System.out.println(result);
	}

	public static String solution(int n) {
		String[] numbers = {"4", "1", "2"};
		String result = "";

		while(0 < n){
			int mok = n % 3;
			n /= 3;
			if(mok == 0) n--;
			result = numbers[mok] + result;
		}

		return result;
    }

}
