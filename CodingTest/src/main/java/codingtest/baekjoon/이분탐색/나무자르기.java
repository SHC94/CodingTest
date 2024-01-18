package codingtest.baekjoon.이분탐색;

import java.util.Scanner;

public class 나무자르기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] tree = new int[N];
		
		int min = 0;
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
			
			if(max < tree[i]) {
				max = tree[i];
			}//end if()
		}//end for()
		
		while(min < max) {
			
			int mid = (min + max) / 2;
			long sum = 0;
			for(int treeHeight : tree) {
				
				if(treeHeight - mid > 0) { 
					sum += (treeHeight - mid);
				}//end if()
			}//end for()
			
			if(sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}//end if()
		}//end while()
		
		System.out.println(min - 1);
	}//end main()
	
}//end class()
