package codingtest.baekjoon.브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class 덩치 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		int[] result = new int[N];
		Arrays.fill(result, 1);
		
		for(int a = 0 ; a < N ; a++) {
			arr[a][0] = sc.nextInt();
			arr[a][1] = sc.nextInt();
		}//end for()
		
		
		for(int a = 0 ; a < arr.length - 1; a++) {
			for(int b = a + 1 ; b < arr.length ; b++) {
				if((arr[b][0] < arr[a][0]) && (arr[b][1] < arr[a][1])) {
					result[b]++;
				} else if((arr[a][0] < arr[b][0]) && (arr[a][1] < arr[b][1])) {
					result[a]++;
				}
			}//end for()
		}//end for()
		
		for(int a = 0 ; a < result.length ; a++) {
			if(a != result.length - 1) {
				System.out.print(result[a] + " ");
			} else {
				System.out.print(result[a]);
			}
		}//end for()
	}//end main()

}//end class()