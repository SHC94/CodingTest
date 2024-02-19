package codingtest.programmers.level2;

import java.util.*;

public class 프렌즈4블록 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/17679
//		입출력 예제
//		m	n	board															answer
//		4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]							14
//		6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15

		int m			= 6;
		int n			= 6;
		String[] board	= {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		int result 		= solution(m, n, board);
		
		System.out.println(result);
	}//end main()

	private static String[][] map;
	private static Boolean stop = false;
	public static int solution(int m, int n, String[] board) {
		map = drawingMap(m, n, board);

		while(!stop) {
			HashSet<String> remove = searchMap(map);
			removeMap(map, remove);
		}

        return result();
    }

	private static int result() {
		int cnt = 0;
		for (String[] row : map) {
			for (String str : row) {
				if (str == null) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void removeMap(String[][] map, HashSet<String> remove) {
		for(String value : remove) {
			StringTokenizer st = new StringTokenizer(value);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = null;
		}

		reloadMap(map);
	}

	private static void reloadMap(String[][] map) {
		int x = map.length;
        int y = map[0].length;

        for (int a = 0 ; a < y ; a++) {
            for (int b = x - 1 ; b >= 0 ; b--) {
                if (map[b][a] == null) {
                    int k = b - 1;
                    while (k >= 0 && map[k][a] == null) {
                        k--;
                    }
                    if (k >= 0) {
                        map[b][a] = map[k][a];
                        map[k][a] = null;
                    }
                }
            }
        }

	}

	private static HashSet<String> searchMap(String[][] map) {
		HashSet<String> remove 	= new HashSet<>();
		int stopCnt				= 0;
		for(int a = 0 ; a < map.length - 1; a++) {
			for(int b = 0 ; b < map[a].length - 1 ; b++) {
				Boolean pass 					= true;
				String startPoint 				= map[a][b];
				List<String> duplicationList 	= new ArrayList<>();

				for(int q = a ; q < a + 2 ; q++) {
					for(int w = b ; w < b + 2 ; w++) {
						duplicationList.add(q + " " + w);

						if(startPoint == null || map[q][w] == null) {
							pass = false;
						} else if(!startPoint.equals(map[q][w])) {
							pass = false;
						}
					}
				}

				if(pass) {
					for(String value : duplicationList) remove.add(value);
					stopCnt++;
				}
				duplicationList.clear();
			}
		}

		if(stopCnt == 0) stop = true;

		return remove;
	}

	private static String[][] drawingMap(int m, int n, String[] board) {
		String[][] map = new String[m][n];

		for(int a = 0 ; a < m ; a++) {
			String str = board[a];
			for(int b = 0 ; b < str.length() ; b++) {
				map[a][b] = String.valueOf(board[a].charAt(b));
			}
		}

		return map;
	}

}
