package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 덧칠하기 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/161989

//		입출력 예
//		n	m	section			result
//		8	4	[2, 3, 6]		2
//		5	4	[1, 3]			1
//		4	1	[1, 2, 3, 4]	4
		
		int n			= 4;
		int m			= 1;
		int[] section	= {1, 2, 3, 4};
		
		int result = solution(n, m, section);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
		
        
	}

	private static int solution(int n, int m, int[] section) {
        Arrays.sort(section);
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int a = 0 ; a < section.length ; a++) q.add(section[a]);

        int result = 0;
        
        while(!q.isEmpty()) {
        	int index = q.peek();
        	for(int a = 0 ; a < m ; a++) {
        		if(q.contains(index)) q.poll();
        		index++;
        	}
        	result++;
        }
        
        return result;
    }
	

}
