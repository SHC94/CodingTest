package codingtest.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N 				= Integer.parseInt(br.readLine());
		int[] arr			= new int[N];
		
		for(int a = 0 ; a < N ; a++) arr[a] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		StringBuilder result = new StringBuilder();
		
		for(int element : arr) result.append(element).append("\n");
		
		System.out.println(result.toString());
	}

}