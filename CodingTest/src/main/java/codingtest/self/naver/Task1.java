package codingtest.self.naver;

import java.util.Arrays;
import java.util.Stack;

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
		
		int N = 1;
		String S = ""; 
		
		int result = solution(N, S);
		
		System.out.println("result = " + result);
	}

	private static boolean[][] map;
	private static int solution(int N, String S) {
		map 					= new boolean[N][10];
		String[] reservedSeat 	= S.split(" ");
		int answer 				= 0;
		System.out.println(reservedSeat.length);
		
		if(!S.equals("")) {
			//예약 좌석 확인
			for(int a = 0 ; a < reservedSeat.length ; a++) {

				int row 	= Character.getNumericValue(reservedSeat[a].charAt(0)) - 1;
				int column 	= (int) reservedSeat[a].charAt(1);
				if(column < 73) column = column - 65;
				else column = column - 66;
				System.out.println(row + " , " + column);
				map[row][column] = true;
				
			}//end for()
		}//end if()
		
		
		//4인 가족 앉히기
		for(int a = 0 ; a < map.length ; a++) {
			Stack<String> stack = new Stack<String>();
			
			for(int b = 0 ; b < map[a].length ; b++) {
				
				//통로가 존재하는 경우
				if(b == 3 || b == 7) {
					if(stack.size() != 2) continue; 
				}//end if()
					
				if(map[a][b]) {	//예약 좌석인 경우
					stack.clear();
				} else {		//예약 좌석이 아닌 경우
					stack.push(String.valueOf(a).concat(String.valueOf(b)));
				}//end if()
				
				System.out.println(stack.toString());
				
				if(stack.size() == 4) {	//4명이 다 앉은 경우
					System.out.println("===================================");
					System.out.println(stack.toString());
					System.out.println("===================================");
					stack.clear();
					answer++;
				}//end if()
			}//end for()	
		}//end for()
		
		for(int a = 0 ; a < map.length ; a++) {
			System.out.println(Arrays.toString(map[a]));
		}//end for()
		return answer;
    }//end solution()
	
}//end class()
