package codingtest.baekjoon.브루트포스;

import java.util.Scanner;

public class 연산자끼워넣기 {
	
	public static int MAX = Integer.MIN_VALUE;	// 최댓값 
	public static int MIN = Integer.MAX_VALUE;	// 최솟값 
	public static int[] operator = new int[4];	// 연산자 개수 
	public static int[] number;					// 숫자 
	public static int N;						// 숫자 개수 
 
	public static void main(String[] args) {
		Scanner in 	= new Scanner(System.in);
		N 			= in.nextInt();
		number 		= new int[N];
 
		for (int i = 0; i < N; i++) number[i] = in.nextInt();
		for (int i = 0; i < 4; i++) operator[i] = in.nextInt();
 
		dfs(number[0], 1);
 
		System.out.println(MAX);
		System.out.println(MIN);
	}//end main()
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}//end if()
 
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {

				operator[i]--;
 
				switch (i) {
 
					case 0:	dfs(num + number[idx], idx + 1);	break;
					case 1:	dfs(num - number[idx], idx + 1);	break;
					case 2:	dfs(num * number[idx], idx + 1);	break;
					case 3:	dfs(num / number[idx], idx + 1);	break;
 
				}//end switch()
				operator[i]++;
			}//end if()
		}//end for()
	}//end dfs()
	
}//end class()