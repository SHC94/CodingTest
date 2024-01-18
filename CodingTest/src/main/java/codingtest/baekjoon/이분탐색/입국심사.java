package codingtest.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 입국심사 {
	private static int n;
    private static int peopleCount;
    private static int[] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		parseInput(br);
		bw.append(String.valueOf(calcMinTime()));

		br.close();
		bw.close();
	}//end main()

	private static long calcMinTime() {
		long start 	= 1;
		long end 	= (long) peopleCount * times[times.length - 1];
		long answer = 0;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			long maxPeopleCount = getPeopleCnt(mid, times);

			if (maxPeopleCount < peopleCount) {
				start = mid + 1;
			} else {
				end = mid - 1;
				answer = mid;
			}//end if()
		}//end while()
		return answer;
	}//end calcMinTime()

	private static long getPeopleCnt(long timeLimit, int[] times) {
		long count = 0;
		
		for (int time : times) {
			count += timeLimit / time;
		}//end for()
			
		return count;
	}//end getPeopleCnt()

	private static void parseInput(BufferedReader br) throws IOException {
		String[] line 	= br.readLine().split(" ");
		n 				= Integer.parseInt(line[0]);
		peopleCount 	= Integer.parseInt(line[1]);
		times 			= new int[n];
		
		for (int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(br.readLine());
		}//end for()
			
		Arrays.sort(times);
	}//end parseInput()

}// end class()