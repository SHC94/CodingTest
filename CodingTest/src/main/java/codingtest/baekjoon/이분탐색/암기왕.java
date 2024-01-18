package codingtest.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 암기왕 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw 	= new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase 		= Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int N 							= Integer.parseInt(br.readLine());
			StringTokenizer st 				= new StringTokenizer(br.readLine());
			HashMap<Integer, Boolean> map 	= new HashMap<>();
			
			for (int j = 0; j < N; j++) {
				map.put(Integer.parseInt(st.nextToken()), true);
			}//end for()

			int M = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (map.containsKey(Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}//end if()
			}//end for()
		}//end for()
		
		bw.flush();
		bw.close();
		br.close();
	}// end main()

}// end class()