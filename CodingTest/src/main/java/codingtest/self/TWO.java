package codingtest.self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.hibernate.internal.build.AllowSysOut;

public class TWO {
	
	public static void main(String[] args) {
		
		
		int[][] data			= {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
		int[] result 			= solution(data);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	private static int[][] result;
	private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	private static int breakCnt = 0;
	
	public static int[] solution(int[][] data) {
        int[] answer 					= new int[data.length];
        HashMap<Integer, Integer> map 	= new HashMap<Integer, Integer>();
        
        result = data;
        for(int a = 1 ; a < data.length; a++) {
        	map.put(data[a][2], data[a][0]);
        }//end for()
        
        int jobIndex 		= data[0][0];
        int jobPageCnt		= data[0][2];
        int time			= 0;
        
        while(true) {
        	System.out.println(time + " / " + jobIndex + " /" + jobPageCnt);
        	
        	//선행 작업이 끝났고, 대기열이 남아 있는 경우
        	if(jobPageCnt <= 0 && !queue.isEmpty()) {
        		int page 	= queue.poll();
        		jobIndex 	= map.get(page);
                jobPageCnt	= page;
                breakCnt++;
                System.out.println(">>>>>>>>> " + breakCnt);
        	}//end if()
        	
        	//요청시간에 다른 인쇄작업 출력
        	print(time);
        	
        	//전체 요청 문서 만큼 반복된 경우 종료
        	System.out.println(breakCnt + " / " + data.length);
        	if(breakCnt == data.length) {
        		break;
        	}//end if()
        	
        	jobPageCnt--;
        	time++;
        }//end while()
        
        return answer;
	}//end solution()

	private static void print(int time) {
		
		for(int a = 1 ; a < result.length ; a++) {
			int requestTime = result[a][1];	//요청 시간
			System.out.println("time = " + time);
			System.out.println("requestTime = " + requestTime);
			if(time == requestTime) {
				System.out.println(time + "!!!!!!!!!!!!!!!!!!!!! " + requestTime);
				queue.add(result[a][2]);
			}//end if()
		}//end for()
	}//end print()
	
}//end class()