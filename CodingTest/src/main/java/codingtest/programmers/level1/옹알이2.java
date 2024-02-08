package codingtest.programmers.level1;

public class 옹알이2 {
	
	public static void main(String[] args) {

		// https://school.programmers.co.kr/learn/courses/30/lessons/133499
//		입출력 예
//		babbling										result
//		["aya", "yee", "u", "maa"]						1
//		["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2

		String[] babbling	= {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		int result 			= solution(babbling);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
	}
	
	public static int solution(String[] babbling) {
		int result = 0;
		
		for (int i = 0 ; i < babbling.length ; i++) {
            babbling[i] = babbling[i].replace("ayaaya"	, "1");
            babbling[i] = babbling[i].replace("yeye"	, "1");
            babbling[i] = babbling[i].replace("woowoo"	, "1");
            babbling[i] = babbling[i].replace("mama"	, "1");
            babbling[i] = babbling[i].replace("aya"		, " ");
            babbling[i] = babbling[i].replace("ye"		, " ");
            babbling[i] = babbling[i].replace("woo"		, " ");
            babbling[i] = babbling[i].replace("ma"		, " ");
            babbling[i] = babbling[i].replace(" "		, "");
            
            if(babbling[i].length() == 0) result++;
        }
		
        return result;
    }

}
