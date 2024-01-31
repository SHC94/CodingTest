package codingtest.programmers.level1;

import java.util.Arrays;

public class 바탕화면정리 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/161990

//		입출력 예
//		wallpaper	result
//		[".#...", "..#..", "...#."]	
//		[0, 1, 3, 4]
		
//		["..........", ".....#....", "......##..", "...##.....", "....#....."]	
//		[1, 3, 5, 8]
		
//		[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]	
//		[0, 0, 7, 9]
		
//		["..", "#."]	
//		[1, 0, 2, 1]
		
		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
		
		int[] result = solution(wallpaper);
		System.out.println(Arrays.toString(result));
		
        
	}

	private static String[][] map;
	private static int[] solution(String[] wallpaper) {
		map = new String[wallpaper.length][wallpaper[0].length()];

		mapDrawing(wallpaper);
		
        return resultCalurate();
    }
	
	private static int[] resultCalurate() {
		int xMin = Integer.MAX_VALUE;
		int xMax = Integer.MIN_VALUE;
		int yMin = Integer.MAX_VALUE;
		int yMax = Integer.MIN_VALUE;
		
		for(int a = 0 ; a < map.length ; a++) {
			for(int b = 0 ; b < map[a].length ; b++) {
				if(map[a][b].equals("#")) {
					if(b <= xMin) xMin = b;
					if(xMax <= b) xMax = b;
					if(a <= yMin) yMin = a;
					if(yMax <= a) yMax = a;
				}
			}
		}
		
		int[] dragSize = {yMin, xMin, (yMax + 1), (xMax + 1)};
		return dragSize;
	}
	
	private static void mapDrawing(String[] wallpaper) {
		for(int a = 0 ; a < wallpaper.length ; a++) {
			String wallPaperLine = wallpaper[a];
			for(int b = 0 ; b < wallPaperLine.length() ; b++) 
				map[a][b] = String.valueOf(wallPaperLine.charAt(b)); 
		}
	}

}
