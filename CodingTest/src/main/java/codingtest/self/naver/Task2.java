package codingtest.self.naver;

import java.util.HashSet;

public class Task2 {

	//이기면 2점
	//비기면 1점
	//지면 0점
	//게임 내내 같은 동작을 낼 것이다.
	//이 전략을 사용해서 득점할 수 있는 최대 점수는 얼마인가요?
	
	//R 바위
	//P 보자기
	//S 가위
	
	
	public static void main(String[] args) {
		
		String S = "22:22:21";
		String T = "22:22:23";
		
		int result = solution(S, T);
		
		System.out.println("result = " + result);
	}

	private static final String MAX_TIME = "60";
	private static final String MIN_TIME = "00";
	
	private static int solution(String S, String T) {
		int result 			= 0;
		String time 		= "";
		String[] timeArr 	= S.split(":");
		String hour			= timeArr[0];
		String minute 		= timeArr[1];
		String second		= timeArr[2];
		
		while(!time.equals(T)) {
			
			time = hour.concat(":").concat(minute).concat(":").concat(second);
			int interestCnt = interestPointOfViewCheck(time);
			if(interestCnt <= 2) result++;

			second = digit(second);
			
			if(MAX_TIME.equals(second)) {
				second = MIN_TIME;
				minute = digit(minute);
				
				if(MAX_TIME.equals(minute)) {
					minute = MIN_TIME;
					hour = digit(hour);
				}//end if()
			}//end if()
			
		}//end while()
		
		return result;
	}//end solution()

	private static int interestPointOfViewCheck(String time) {
		HashSet<String> set = new HashSet<String>();
		
		for(int a = 0 ; a < time.length() ; a++) {
			String timeDiv = String.valueOf(time.charAt(a));
			
			if(!timeDiv.equals(":")) set.add(timeDiv);
		}//end for()

		return set.size();
	}//end for()

	private static String digit(String time) {
		return Integer.parseInt(time) + 1 < 10 ? "0".concat(String.valueOf(Integer.parseInt(time) + 1)) : String.valueOf(Integer.parseInt(time) + 1);
	}//end digit()
	
}//end class()
