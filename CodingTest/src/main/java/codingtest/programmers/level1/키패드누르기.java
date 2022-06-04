package codingtest.programmers.level1;

import java.util.HashMap;

public class 키패드누르기 {
	
	public static void main(String[] args) {
		
//		numbers								hand	result
//		[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
//		[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
//		[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]		"right"	"LLRLLRLLRL"

	  	int[] numbers	= {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	  	String hand		= "right";
		
	  	String result 	= solution(numbers, hand);
		System.out.println(result);
	}//end main()
	
	public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        String leftPosition		= "*";
        String rightPosition	= "#";
        
        HashMap<String, String> keyPadMap = keyPad();
        
        for(int a = 0 ; a < numbers.length ; a++) {
        	String number = String.valueOf(numbers[a]);	//눌러야할 숫자
        	
        	
        	if((number.equals("1")) || (number.equals("4")) || (number.equals("7"))) {
        		answer.append("L");		//좌측 1, 4, 7은 왼손으로 누르기
        		leftPosition = number;	//왼손 포지션 이동
        	} else if((number.equals("3")) || (number.equals("6")) || (number.equals("9"))) {
        		answer.append("R");		//우측 3, 6, 9는 오른손으로 누르기
        		rightPosition = number;	//오른손 포지션 이동
        	} else {
        		//거리 계산
        		int x1 = Integer.parseInt(keyPadMap.get(number).split(" ")[0]);
        		int y1 = Integer.parseInt(keyPadMap.get(number).split(" ")[1]);
        		
        		int x2 = Integer.parseInt(keyPadMap.get(leftPosition).split(" ")[0]);
        		int y2 = Integer.parseInt(keyPadMap.get(leftPosition).split(" ")[1]);
        		
        		int x3 = Integer.parseInt(keyPadMap.get(rightPosition).split(" ")[0]);
        		int y3 = Integer.parseInt(keyPadMap.get(rightPosition).split(" ")[1]);
        		
        		int leftDistance 	= Math.abs(x1 - x2) + Math.abs(y1 - y2);
        		int rightDistance 	= Math.abs(x1 - x3) + Math.abs(y1 - y3);
        		
        		//거리가 가까운 손이 누르기
        		if(leftDistance < rightDistance) {
        			answer.append("L");
            		leftPosition = number;
        		} else if(rightDistance < leftDistance) {
        			answer.append("R");
            		rightPosition = number;
            		
            	//거리가 같다면 주 손이 누르기
        		} else {
        			if("right".equals(hand)) {
        				answer.append("R");
                		rightPosition = number;
        			} else if("left".equals(hand)) {
        				answer.append("L");
                		leftPosition = number;
        			}//end if()
        		}//end if()
        		
        	}//end if()
        	
        }//end for()
        
        return answer.toString();
    }//end solution()

	private static HashMap<String, String> keyPad() {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("1", "0 0");
		resultMap.put("2", "0 1");
		resultMap.put("3", "0 2");
		resultMap.put("4", "1 0");
		resultMap.put("5", "1 1");
		resultMap.put("6", "1 2");
		resultMap.put("7", "2 0");
		resultMap.put("8", "2 1");
		resultMap.put("9", "2 2");
		resultMap.put("*", "3 0");
		resultMap.put("0", "3 1");
		resultMap.put("#", "3 2");		
		return resultMap;
	}
	
}//end class()
