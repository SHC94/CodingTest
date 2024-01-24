package codingtest.baekjoon.약수배수와소수;

import java.io.IOException;
import java.util.Scanner;

public class 골드바흐파티션 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

        boolean[] primeNumber = new boolean[1000001];
        primeNumber[0] = true;
        primeNumber[1] = true;
        for(int i = 2 ; i <= Math.sqrt(1000000) ; i++) {
            if(primeNumber[i]) continue;
            for(int j = i * i ; j < 1000001 ; j+= i) {
                primeNumber[j] = true;
            }
        }

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++) {
            int cnt = 0;
            int tmp = sc.nextInt();
            for(int j = 2 ; j <= tmp / 2 ; j++) 
            	if(!primeNumber[j] && !primeNumber[tmp-j])cnt++;

            System.out.println(cnt);
        }
	}

}
