package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 다음소수 {

	public static void main(String[] args) throws IOException {
		Scanner sc 	= new Scanner(System.in);
		long N 		= sc.nextInt();
		
		for(long a = 0 ; a < N ; a++) {
			long test = sc.nextLong();
			
			if(test == 0 || test == 1 || test == 2) {
                System.out.println(2);
                continue;
            }
			
			while(true) {
				int result = 0;
				
				for(long b = 2 ; b <= Math.sqrt(test) ; b++) {
					if(test % b == 0) {
						result++;
                        break;
					}
				}
				
				if(result == 0) {
                    System.out.println(test);
                    break;
                }

				test++;
				
			}
		}
	}
		

}
