package codingtest.programmers.level1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class 이천십육년 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/12901
		
//		입출력 예
//		a	b	result
//		5	24	"TUE"
		
		int a = 5;
		int b = 24;
		
		String result = process(a, b);
		
        System.out.println(result);
		
	}

	private static String process(int a, int b) {
		LocalDate date = LocalDate.of(2016, a, b);
		DayOfWeek dayOfWeek = date.getDayOfWeek(); 
		int dayOfWeekValue = dayOfWeek.getValue();
		
		return transResult(dayOfWeekValue);
	}

	private static String transResult(int dayOfWeekValue) {
		String result = "";
		
		if(dayOfWeekValue == 1) result = "MON";
		else if(dayOfWeekValue == 2) result = "TUE";
		else if(dayOfWeekValue == 3) result = "WED";
		else if(dayOfWeekValue == 4) result = "THU";
		else if(dayOfWeekValue == 5) result = "FRI";
		else if(dayOfWeekValue == 6) result = "SAT";
		else if(dayOfWeekValue == 7) result = "SUN";
		
		return result;			
	}

}
