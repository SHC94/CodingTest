package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 데이터분석 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/250121

//		data	ext	val_ext	sort_by	result
//		[[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]
//		"date"	
//		20300501	
//		"remain"	
		
//		[[3,20300401,10,8],[1,20300104,100,80]]

		int[][] data	= {{1, 20300104, 100, 80}
							, {2, 20300804, 847, 37}
							, {3, 20300401, 10, 8}};	
		// 코드번호, 제조일, 최대수량, 현재수
		String ext		= "date";
		int val_ext		= 20300501;
		String sort_by	= "remain";
		
		int[][] result 	= process(data, ext, val_ext, sort_by);
		
		for(int a = 0 ; a < result.length ; a++) {
			System.out.println(Arrays.toString(result[a]));
		}
        
	}

	private static int[][] process(int[][] data, String ext, int val_ext, String sort_by) {
		int index = 0;
		
		if("code".equals(ext)) index = 0;
		else if("date".equals(ext)) index = 1;
		else if("maximum".equals(ext)) index = 2;
		else if("remain".equals(ext)) index = 3;

		List<int[]> list = new ArrayList<>();
		
		for(int a = 0 ; a < data.length ; a++) {
			if(data[a][index] < val_ext) {
				list.add(data[a]);
			}
		}
		
		int sort = 0;
		if("code".equals(sort_by)) sort = 0;
		else if("date".equals(sort_by)) sort = 1;
		else if("maximum".equals(sort_by)) sort = 2;
		else if("remain".equals(sort_by)) sort = 3;
		
		int listIndex = sort;
		
		list.sort(Comparator.comparingInt(arr -> arr[listIndex]));

		int[][] result = list.toArray(new int[0][]);
		
		return result;
	}

}
