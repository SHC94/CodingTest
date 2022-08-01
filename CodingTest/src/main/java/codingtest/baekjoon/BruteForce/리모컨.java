package codingtest.baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 리모컨 {

	private static int min = Integer.MAX_VALUE;
	private static String target;
	private static int target_num;
	private static boolean[] btn = { true, true, true, true, true, true, true, true, true, true };

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		target 				= br.readLine();
		target_num 			= Integer.parseInt(target);
		int broken 			= Integer.parseInt(br.readLine());
		String[] broken_num;

		if (broken != 0) {
			broken_num = br.readLine().split(" ");
			for (int i = 0; i < broken_num.length; i++) {
				btn[Integer.parseInt(broken_num[i])] = false;
			}//end for()
		}//end if()

		if ("100".equals(target)) {
			System.out.println(0);
			return;
		}//end if()

		int cnt = Math.abs(100 - target_num);
		min = min > cnt ? cnt : min;

		dfs(0, "");
		System.out.println(min);
	}//end main()

	private static void dfs(int idx, String click) {
		for (int i = 0; i < 10; i++) {
			if (btn[i]) {
				
				String newStr 	= click + Integer.toString(i);
				int cnt 		= Math.abs(target_num - Integer.parseInt(newStr)) + newStr.length();
				min 			= min > cnt ? cnt : min;
				
				if (idx < 6) dfs(idx + 1, newStr);
					
			}//end if()
		}//end for()
	}//end dfs()

}// end class()