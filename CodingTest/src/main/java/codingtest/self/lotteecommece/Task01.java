package codingtest.self.lotteecommece;

import java.util.Arrays;

public class Task01 {
	
	public static void main(String[] args) {

		long n = 1000000000;
		long[] result = solution(n);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	private static boolean[] weekend = {false, false, false, false, false, true, true};
	private static long min = Long.MAX_VALUE;
	private static long max = Long.MIN_VALUE;
	
	public static long[] solution(long n) {
		long[] answer = new long[2];
		
		
		//월요일부터 일요일까지
		for(long a = 0 ; a < 7 ; a++) {
			System.out.println(a + " 요일 출발");
			long cnt = 0;
			for(long b = a ; b < a + n ; b++) {
				int index = (int) (b % 7);
				boolean pass = weekend[index];
				System.out.println(b + " " + pass);
				
				if(pass) cnt++;
			}//end for()
			
			if(cnt < min) min = cnt;
			if(max < cnt) max = cnt;
		}//end for()
		
		System.out.println(min + " " + max);
		answer[0] = min;
		answer[1] = max;
        return answer;
	}//end solution()

}//end class()
