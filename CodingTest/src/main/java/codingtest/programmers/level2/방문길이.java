package codingtest.programmers.level2;

import java.util.HashMap;
import java.util.HashSet;

public class 방문길이 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/49994
//		dirs		answer
//		"ULURRDLLU"	7
//		"LULLLLLLU"	7

		String dirs		= "LLLLRLRLRLL";
		int result 		= solution(dirs);
		
		System.out.println(result);
	}//end main()

//U: 위쪽으로 한 칸 가기
//D: 아래쪽으로 한 칸 가기
//R: 오른쪽으로 한 칸 가기
//L: 왼쪽으로 한 칸 가기

	private static String[][] board = new String [11][11];
	private static HashMap<String, int[]> dir = new HashMap<>();
	private static HashSet<String> pass = new HashSet<>();
	private static int[] currentLocation = {5, 5};

	public static int solution(String dirs) {

		setting();
		move(dirs);

        return pass.size() / 2;
    }

	private static void move(String dirs) {
		for(int a = 0 ; a < dirs.length() ; a++) {
			int x = currentLocation[0];
			int y = currentLocation[1];

			String direct = String.valueOf(dirs.charAt(a));
			int moveX = dir.get(direct)[0];
			int moveY = dir.get(direct)[1];

			if((x + moveX) < 0 || board.length < (x + moveX) || (y + moveY) < 0 || board[0].length <= (y + moveY)) {

			} else {
				currentLocation[0] = x + moveX;
				currentLocation[1] = y + moveY;
				pass.add("" + x + y + currentLocation[0] + currentLocation[1]);
				pass.add("" + currentLocation[0] + currentLocation[1] + x + y);
			}

		}
	}

	private static void setting() {
		// 방향 설정
		int[] dirArr = new int[2];
		dirArr = new int[]{0, -1};
		dir.put("U", dirArr);

		dirArr = new int[]{0, 1};
		dir.put("D", dirArr);

		dirArr = new int[]{1, 0};
		dir.put("R", dirArr);

		dirArr = new int[]{-1, 0};
		dir.put("L", dirArr);
	}

}
