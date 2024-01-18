package codingtest.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 기타레슨 {
	
	private static int N, M;
	private static int[] lesson;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr 	= br.readLine().split(" ");
		N 				= Integer.parseInt(arr[0]);
		M 				= Integer.parseInt(arr[1]);
		lesson 			= new int[N];
		int max 		= 0;
		arr 			= br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(arr[i]);
			max = Math.max(max, lesson[i]);
		}//end for()

		bw.write(search(max, 1000000000) + "\n");
		bw.flush();

	}//end main()

	public static int search(int left, int right) {

		int pl = left;
		int pr = right;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			int cnt = 1;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				sum += lesson[i];
				if (sum > pc) {
					sum = lesson[i];
					cnt++;
				} // end if()
			} // end for()

			if (cnt > M) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			} // end if()

		} // end while()

		return pl;
	}// end search()
}//end class()