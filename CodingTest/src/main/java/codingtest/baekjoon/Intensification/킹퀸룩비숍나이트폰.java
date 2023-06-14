package codingtest.baekjoon.Intensification;

import java.io.IOException;
import java.util.Scanner;

public class 킹퀸룩비숍나이트폰 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int[] chess 	= {1, 1, 2, 2, 2 ,8};
		int[] resultArr	= new int[chess.length];
		
		for(int a = 0 ; a < chess.length ; a++) {
			int compareNum = sc.nextInt();
			resultArr[a] = chess[a] - compareNum;
		}
		
		StringBuilder result = new StringBuilder();
		for(int a = 0 ; a < resultArr.length ; a++) {
			if(a == resultArr.length - 1) result.append(resultArr[a]);
			else result.append(resultArr[a]).append(" "); 
		}
		
		System.out.println(result.toString());
	}//end main()

}//end class()