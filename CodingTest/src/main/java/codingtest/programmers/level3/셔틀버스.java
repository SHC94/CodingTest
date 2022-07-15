package codingtest.programmers.level3;

import java.util.PriorityQueue;

public class 셔틀버스 {
	
	public static void main(String[] args) {
				
//		입출력 예제
//		n	t	m	timetable										answer
//		1	1	5	["08:00", "08:01", "08:02", "08:03"]			"09:00"
//		2	10	2	["09:10", "09:09", "08:00"]						"09:09"
//		2	1	2	["09:00", "09:00", "09:00", "09:00"]			"08:59"
//		1	1	5	["00:01", "00:01", "00:01", "00:01", "00:01"]	"00:00"
//		1	1	1	["23:59"]										"09:00"
//		10	60	45	["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]	"18:00
				
		int n	= 1; 
		int t 	= 1;
		int m 	= 1;
		String[] timetable	= {"23:59"};
		String result 		= solution(n, t, m, timetable);
		
		System.out.println(result);
	}//end main()
	
//	셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다.
//	셔틀은 도착했을 때 도착한 순간에 대기열에 선 크루까지 포함해서 대기 순서대로 태우고 바로 출발한다. 예를 들어 09:00에 도착한 셔틀은 자리가 있다면 09:00에 줄을 선 크루도 탈 수 있다.
	public static String solution(int n, int t, int m, String[] timetable) {
		System.out.println("셔틀은 09:00부터 총 "+n+"회 "+t+"분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 "+m+"명의 승객이 탈 수 있다.");
		
		//대기하는 사람들 담기 (우선순위)
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(String table : timetable) {
            int time = Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3));
            queue.add(time);
        }//end for()
     
        int start 	= 540;
        int last 	= 0;
        int total 	= 0;
        
        //셔틀 도착
        for(int i = 0 ; i < n ; i++) {
            total = 0;    
            
            //대기열 사람들 버스 타기
            while(!queue.isEmpty()) {
                int qPoll = queue.peek();
                
                //버스 도착 시간 보다 늦지 않고 정원을 초과하지 않은 경우
                if(qPoll <= start && total < m) {
                    queue.poll();
                    total++;
                } else {
                	break;
                }//end if()
                
                //가장 늦게 타려면 마지막 사람보다 1분 빠르면 됨
                last = qPoll - 1;
            }//end while()
            
            //다음 도착 시간
            start += t;
            
        }//end for()
        
        if(total < m) last = start - t;
        
        String hour = String.valueOf((last / 60));
        String minu = String.valueOf((last % 60));
        
        if(hour.length() < 2) hour = "0" + hour;
        if(minu.length() < 2) minu = "0" + minu;
        String answer = hour + ":" + minu; 
        return answer;
	}//end solution()
	
}//end class()