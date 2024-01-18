package codingtest.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 부분수열의합2 {
	private static int n, s, arr[];
	private static List<Integer> leftlist, rightlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st 	= new StringTokenizer(br.readLine());

		n 	= Integer.parseInt(st.nextToken());
		s 	= Integer.parseInt(st.nextToken());
		arr = new int[n];
		st 	= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//end for()

		leftlist 	= new ArrayList<>();
		rightlist 	= new ArrayList<>();
		
		dfs(0, n / 2, 0, leftlist);
		dfs(n / 2, n, 0, rightlist);

		Collections.sort(rightlist);

		long ans = 0;
		for (int val : leftlist) {
			val = s - val;
			int lo = upper_bound(rightlist, val);
			int hi = lower_bound(rightlist, val);
			ans += hi - lo;
		}//end for()

		if (s == 0) --ans;
		System.out.println(ans);
	}//end main()

	private static int lower_bound(List<Integer> list, int val) {
		int left = 0;
		int right = list.size();
		int mid;
		while (left < right) {
			mid = (left + right) >> 1;
			if (list.get(mid) > val) {
				right = mid;
			} else {
				left = mid + 1;
			}//end if()
		}//end while()
		return left;
	}//end lower_bound()

	private static int upper_bound(List<Integer> list, int val) {
		int left = 0;
		int right = list.size();
		int mid;
		while (left < right) {
			mid = (left + right) >> 1;
			if (list.get(mid) < val) {
				left = mid + 1;
			} else {
				right = mid;
			}//end if()
		}//end while()
		return left;
	}//end upper_bound()

	private static void dfs(int index, int end, int sum, List<Integer> list) {
		if (index == end) {
			list.add(sum);
			return;
		}
		dfs(index + 1, end, sum, list);
		dfs(index + 1, end, sum + arr[index], list);
	}//end dfs()
	
}// end class()