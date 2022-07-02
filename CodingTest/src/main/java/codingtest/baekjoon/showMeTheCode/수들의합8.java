package codingtest.baekjoon.showMeTheCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class 수들의합8 {

//	문제
//	길이가 같은 정수 수열 $A = \{A_1, A_2, ..., A_N\}$와 $B = \{B_1, B_2, ..., B_N\}$가 주어진다.
//
//	 $A_i + A_{i+1} + ... + A_j = B_i + B_{i+1} + ... + B_j$를 만족하는 양의 정수 $i, j ~(i \leq j)$쌍의 개수를 구해보자.
//
//	입력
//	첫 번째 줄에 양의 정수 $N$이 주어진다.
//
//	두 번째 줄에 $A$를 나타내는 $N$개의 양의 정수 $A_i$가 $A_1$부터 $A_N$까지 순서대로, 공백으로 구분되어 주어진다.
//
//	세 번째 줄에 $B$를 나타내는 $N$개의 양의 정수 $B_i$가 $B_1$부터 $B_N$까지 순서대로, 공백으로 구분되어 주어진다.
//
//	출력
//	 $A_i + A_{i+1} + ... + A_j = B_i + B_{i+1} + ... + B_j$를 만족하는 양의 정수 $i, j ~(i \leq j)$쌍의 개수를 출력한다.
//
//	제한
//	 $1 \leq N \leq 2\cdot 10^5$ 
//	 $\lvert A \rvert = \lvert B \rvert = N$ 
//	 $1 \leq A_i,B_i \leq 10^4$ 
//	예제 입력 1 
//	3
//	1 2 3
//	1 3 2
//	예제 출력 1 
//	3
//	 $A = \{1, 2, 3\}$, $B = \{1, 3, 2\}$로, 조건을 만족하는 $i, j$ 쌍은 $(1, 1), (2, 3), (1, 3)$의 세 가지이다.
//
//	 $A_1$ = $B_1 = 1$ 
//	 $A_2 + A_3 = B_2 + B_3 = 5$ 
//	 $A_1 + A_2 + A_3 = B_1 + B_2 + B_3 = 6$
	
	private static HashSet<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);
		int N		= sc.nextInt();			//몬스터의 수
		int[] A 	= new int[N];
		int[] B 	= new int[N];
		int[] index	= new int[N];
		boolean[] visited = new boolean[N];
		int result 	= 0;
		
		for(int a = 0 ; a < A.length ; a++) A[a] = sc.nextInt();
		for(int a = 0 ; a < B.length ; a++) B[a] = sc.nextInt();
		for(int a = 0 ; a < index.length ; a++) index[a] = a;

		for(int a = 1 ; a <= 2 ; a++) {
			combination(index, visited, 0 , index.length , a);
		}//end for()
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String area = iter.next();
			int start = Integer.parseInt(area.split("/")[0]);
			int end = Integer.parseInt(area.split("/")[1]);
			int asum = 0;
			int bsum = 0;
			
			for(int a = start ; a <= end ; a++) {
				asum += A[a];
				bsum += B[a];
			}//end for()
			
			if(asum == bsum) result++;
		}//end while()
		
		System.out.println(set.toString());
		System.out.println(result);
		
	}//end main()

	private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
           print(arr, visited, n);
           return;
        }//end if()

        for(int i = start ; i < n ; i++) {
           visited[i] = true;
           combination(arr, visited, i + 1, n, r - 1);
           visited[i] = false;
        }//end for()
     }//end combination()
     
	private static void print(int[] arr, boolean[] visited, int n) {
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		
        for(int i = 0; i < n; i++) {
        	if (visited[i]) {
        		if(arr[i] < start) start = arr[i];
        		if(end < arr[i]) end = arr[i];
        	}
        }//end for()
        
        set.add(start + "/" + end);
     }//end print()
}//end class()