package codingtest.programmers.level2;

import java.util.*;

public class 호텔대실 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/155651
//		입출력 예
//		book_time	result
//		[["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
//		3
//		[["09:10", "10:10"], ["10:20", "12:20"]]
//		1
//		[["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]
//		3

//		String[][] book_time	= {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
//		String[][] book_time	= {{"09:10", "10:10"}, {"10:20", "12:20"}};
		String[][] book_time	= {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
		int result 				= solution(book_time);
		
		System.out.println(result);
	}//end main()

	public static int solution(String[][] book_time) {
		Arrays.sort(book_time, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].equals(o2[0]))
					return o1[1].compareTo(o2[1]);
				else
					return o1[0].compareTo(o2[0]);
			}
		});

		int[][] time = new int[book_time.length][2];

		for (int a = 0 ; a < book_time.length ; a++) {
				int startTime 	= Integer.parseInt(book_time[a][0].replace(":", ""));
				int endTime 	= Integer.parseInt(book_time[a][1].replace(":", ""));

				endTime += 10;
	            if(endTime % 100 >= 60){
	                endTime += 40;
	            }

	            time[a][0] = startTime;
	            time[a][1] = endTime;
		}

		ArrayList<Integer> rooms = new ArrayList<>();
		for (int a = 0 ; a < time.length ; a++) {
			Collections.sort(rooms);

			boolean isAdd = false;

			for (int b = 0 ; b < rooms.size() ; b++) {
				if (time[a][0] >= rooms.get(b)) {
					rooms.set(b, time[a][1]);
					isAdd = true;
					break;
				}
			}

			if (!isAdd) rooms.add(time[a][1]);
		}

		return rooms.size();
    }

}
