package codingtest.self.tmon;

public class Task1 {

	public static void main(String[] args) {

//		두 문자열을 파라메터로 받아서 공통된 문자열 중 가장 긴 문자열을 반환하는 함수를 작성한다.
//		예를 들면 "penpineapple" 와 "applepen" 두 문자열이 주어졌을때, 
//		"apple", "pen" 등이 공통된 문자열로 추출이 될 수 있다. 
//		이 중 최대의 길이를 갖는 문자열은 "apple"이 된다. 
//		이러한 문자열을 반환하는 함수를 작성하시요.
		
		String X = "penpineapple";
		String Y = "applepen";
		String result = solution(X, Y);
		System.out.println(result);
	}//end main()

	private static String solution(String word1, String word2) {
		
		int m 		= word1.length();
		int n 		= word2.length();
		int start 	= 0;
		int end 	= m;

		int[][] lcs = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					if (lcs[i][j] > start) {
						start = lcs[i][j];
						end = i;
					}//end if()
				}//end if()
			}//end for()
		}//end for()

		return word1.substring(end - start, end);
	}//end solution()

}//end class()
