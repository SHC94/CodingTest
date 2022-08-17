package codingtest.self.yanolja;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

	//이기면 2점
	//비기면 1점
	//지면 0점
	//게임 내내 같은 동작을 낼 것이다.
	//이 전략을 사용해서 득점할 수 있는 최대 점수는 얼마인가요?
	
	//R 바위
	//P 보자기
	//S 가위
	
	
	public static void main(String[] args) {
		
		String G = "PPPPRRSSSSS";
		
		int result = solution(G);
		
		System.out.println("result = " + result);
	}

	private static int solution(String G) {
		int result = Integer.MIN_VALUE;	//결과 (최대 점수)
		List<String> francoList = new ArrayList<String>();
		
		francoList.add("R");
		francoList.add("P");
		francoList.add("S");
		
		for(int i = 0 ; i < francoList.size() ; i++) {
			String franco = francoList.get(i);	//프란코가 낸 거
			int divPoint = 0;					//경우마다의 점수
			
			for(int a = 0 ; a < G.length(); a++) {
				String giovanni = String.valueOf(G.charAt(a));	//지오바니가 낸 거
				
				if("R".equals(franco)) {		//바위
					if("R".equals(giovanni)) divPoint += 1;
					else if("S".equals(giovanni)) divPoint += 2;
				} else if("P".equals(franco)){	//보
					if("P".equals(giovanni)) divPoint += 1;
					else if("R".equals(giovanni)) divPoint += 2;
				} else if("S".equals(franco)) {	//가위
					if("S".equals(giovanni)) divPoint += 1;
					else if("P".equals(giovanni)) divPoint += 2;
				}//end if()
			}//end for()
			if(result < divPoint) result = divPoint;
		}//end for()
		
		return result;
	}//end solution()
	
}//end class()
