package codingtest.baekjoon.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		String input 		= br.readLine();

		char[] chars 	= input.toCharArray();
		int n 			= chars.length;
		int ascii 		= 48;
		int[] count 	= new int[2];
		char ch 		= chars[0];

		for (int i = 1; i < n; i++) {
			if (ch != chars[i]) {
				count[ch - ascii]++;
				ch = chars[i];
			}//end if()
		}//end for()

		count[ch - ascii]++;

		System.out.println(Math.min(count[0], count[1]));
	}//end main()

}//end class()