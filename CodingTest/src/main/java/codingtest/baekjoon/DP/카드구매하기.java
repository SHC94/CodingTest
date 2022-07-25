package codingtest.baekjoon.DP;

import java.util.Scanner;

public class 카드구매하기 {

	public static void main(String[] args) {
		Scanner sc 	= new Scanner(System.in);
        int n 		= sc.nextInt();
        int[] arr 	= new int[n + 1];
        int[] d 	= new int[n + 1];

        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + arr[j]);
            }//end for()
        }//end for()

        System.out.println(d[n]);

	}//end main()

}//end class()