package codingtest.yanoljaCodility;

public class Task2 {

	//Junit4 inverter 클래스에 대한 테스트 모음 제공
	//문자열을 받은 후 문자열을 반환
	//빈 문자열은 빈 문자열을 반환
	//null이면 빈 문자열 반환
	
	//문자열의 길이가 1인 경우 문자열을 그대로 반환
	//문자열의 길이가 1보다 길면 반환된 글자가 반환
	
	
	public static void main(String[] args) {
		
		String G = "PPPPRRSSSSS";
		
		String result = solution(G);
		
		System.out.println("result = " + result);
	}

	private static String solution(String G) {
		String inverted = "";
		
		if(G == null || G.isEmpty()) {				//1. 빈 문자열, null은 빈 문자열을 반환
			inverted = "";
		} else if(G.length() == 1) {				//2. 문자열의 길이가 1인 경우 문자열을 그대로 반환
			inverted = G;
		} else if(1 < G.length()) {					//3. 문자열의 길이가 1보다 길면 변환된 글자가 반환
			StringBuilder sb = new StringBuilder(G);
			inverted = sb.reverse().toString();
		}
		
		System.out.println(inverted);
		return inverted;
	}//end solution()
	
}//end class()
