package codingtest.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		int N 				= Integer.parseInt(br.readLine());
		int[] arr 			= new int[N];
		List<Integer> list 	= new ArrayList<>();
		StringTokenizer st 	= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		list.add(0);

		for (int num : arr) {
			if (num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int left = 0;
				int right = list.size() - 1;
				int mid = 0;

				while (left < right) {
					
					mid = (left + right) / 2;
					
					if (list.get(mid) < num)
						left = mid + 1;
					else
						right = mid;
					
				}//end while()

				list.set(right, num);
			}//end if()
		}//end for()

		System.out.println(list.size() - 1);

	}//end main()
	
}//end class()