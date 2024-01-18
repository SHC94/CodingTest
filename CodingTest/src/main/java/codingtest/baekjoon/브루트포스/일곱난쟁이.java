package codingtest.baekjoon.브루트포스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 일곱난쟁이 {
	
	private static List<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//난쟁이 키 입력
		int[] arr = new int[9];
		for(int a = 0 ; a < 9 ; a++) arr[a] = sc.nextInt();
		
		boolean[] visited = new boolean[9];
		
		dwarf(arr, visited, 0, arr.length, 7);
		
		Collections.sort(result);
		
		for(int ans : result) {
			System.out.println(ans);
		}//end for()
	}//end main()

	private static void dwarf(int[] arr, boolean[] visited, int depth, int n, int r) {
		if(result.size() == 0) {
			if(r == 0) {
				combination(arr, visited, n);
				return;
			}//end if()
			
			for(int i = depth ; i < n ; i++) {
				visited[i] = true;
				dwarf(arr, visited, i + 1, n, r - 1);
				visited[i] = false;
			}//end for()
		}//end if()
	}//end dwarf()

	private static void combination(int[] arr, boolean[] visited, int n) {
		List<Integer> tempList = new ArrayList<Integer>();  
		int max = 0;
		
		for(int a = 0 ; a < n ; a++) {
			if(visited[a]) {
				max += arr[a];
				tempList.add(arr[a]);
			}//end if()
		}//end for()
		
		if(max == 100) {
			for(int temp : tempList) result.add(temp);
		}//end if()
	}//end combination()

}//end class()