package codingtest.programmers.level1;

public class 기사단원의무기 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/136798

//		number	limit	power	result
//		5	3	2	10
//		10	3	2	21
		
		int number	= 10;
		int limit	= 3;
		int power	= 2;
		
		int result = solution(number, limit, power);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
		
        
	}

	private static int solution(int number, int limit, int power) {
		int answer = 0;
        
        for(int a = 1 ; a <= number ; a++) {
            
            int count = 0;
            for (int b = 1 ; b * b <= a ; b++) {
                if (b * b == a) count++;
                else if (a % b == 0) count += 2;
            }
            
            answer += count > limit ? power : count;
        }
        
        return answer;
    }
	

}
