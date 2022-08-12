package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {

	public static void main(String[] args) {

//		line	result
//		[[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]	["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
//		[[0, 1, -1], [1, 0, -1], [1, 0, 1]]								["*.*"]
//		[[1, -1, 0], [2, -1, 0]]										["*"]
//		[[1, -1, 0], [2, -1, 0], [4, -1, 0]]							["*"]
				

		int[][] line	= {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};

		String[] result = solution(line);

		System.out.println(Arrays.toString(result));
	}// end main()j

	private static int startX 	= Integer.MAX_VALUE;
	private static int endX 	= Integer.MIN_VALUE;
	private static int startY 	= Integer.MAX_VALUE;
	private static int endY 	= Integer.MIN_VALUE;

	public static String[] solution(int[][] line) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				long a = line[i][0];
				long b = line[i][1];
				long e = line[i][2];
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];
				
				long denominator = (a * d) - (b * c);
				if (denominator == 0)
					continue;

				long number1 = (b * f) - (e * d);
				long number2 = (e * c) - (a * f);
				if (number1 % denominator != 0 || number2 % denominator != 0)
					continue;

				int x = (int) (number1 / denominator);
				int y = (int) (number2 / denominator);

				List<Integer> temp = Arrays.asList((int) x, (int) y);
				if (!list.contains(temp))
					list.add(temp);

				startX 	= Math.min(startX, (int) x);
				endX 	= Math.max(endX, (int) x);
				startY 	= Math.min(startY, (int) y);
				endY 	= Math.max(endY, (int) y);
			}//end for()
		}//end for()

		List<String> board = new ArrayList<>();
		for (int i = startY; i <= endY; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = startX; j <= endX; j++) {
				sb.append(".");
			}//end for()
			board.add(sb.toString());
		}//end for()

		for (List<Integer> charAtList : list) {
			StringBuilder sb = new StringBuilder(board.get(Math.abs(charAtList.get(1) - endY)));
			sb.setCharAt(Math.abs(charAtList.get(0) - startX), '*');
			board.set(Math.abs(charAtList.get(1) - endY), sb.toString());
		}//end for()

		String[] answer = new String[board.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = board.get(i);
		}//end for()

		return answer;
	}//end solution()
}//end class()
