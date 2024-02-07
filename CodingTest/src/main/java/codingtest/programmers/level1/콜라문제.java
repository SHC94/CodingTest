package codingtest.programmers.level1;

public class 콜라문제 {
	
	public static void main(String[] args) {

		// https://school.programmers.co.kr/learn/courses/30/lessons/132267
//		입출력 예
//		a	b	n	result
//		2	1	20	19
//		3	1	20	9

		int a		= 3; 
		int b		= 1; 
		int n		= 20;
		int result 	= solution(a, b, n);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
	}
	
//	콜라를 받기 위해 마트에 주어야 하는 병 수 a, 
//	빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b, 
//	상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다. 
//	상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
			
	public static int solution(int a, int b, int n) {
		int answer = 0;
		
		// 단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.
        while(a <= n) {
        	answer += (n / a) * b;
        	int remain = n % a;
        	
        	n = (n / a) * b + remain;
        }

        return answer;
    }

}
