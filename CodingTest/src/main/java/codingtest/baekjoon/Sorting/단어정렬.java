package codingtest.baekjoon.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class 단어정렬 {
	
	public static void main(String[] args) {
		Scanner sc		= new Scanner(System.in);
		int N 			= sc.nextInt();
		
		//중복 제거
		HashSet<String> set = new HashSet<String>();
		for(int a = 0 ; a < N ; a++) set.add(sc.next());
		
		//배열 변환
		String[] arr 			= new String[set.size()];
		Iterator<String> iter 	= set.iterator();
		int index = 0;
		while(iter.hasNext()) {
			arr[index] = iter.next();
			index++;
		}//end while()
		
		//정렬
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {	// 단어 길이가 같을 경우
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}//end if()
			}//end compare()
		});
		
		for(String result : arr) {
			System.out.println(result);
		}//end for()
	}//end main()

}//end class()