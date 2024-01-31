package codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {

	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/178871

//		입출력 예
//		name	yearning	photo	result
//		["may", "kein", "kain", "radi"]	
//		[5, 10, 1, 3]	
//		[["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]	
//		[19, 15, 6]
		
//		["kali", "mari", "don"]	[11, 1, 55]	[["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]	[67, 0, 55]
//		["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may"],["kein", "deny", "may"], ["kon", "coni"]]	[5, 15, 0]
		
		String[] name		= {"may", "kein", "kain", "radi"};  
		int[] yearning		= {5, 10, 1, 3};
		String[][] photo	= {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		
		int[] result = solution(name, yearning, photo);
		System.out.println(Arrays.toString(result));
		
        
	}

	private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> point = new HashMap<>();
        
        for(int a = 0 ; a < name.length ; a++) 
        	point.put(name[a], yearning[a]);
        
        int[] result = new int[photo.length];
        for(int a = 0 ; a < photo.length ; a++) {
        	int sum = 0;
        	for(int b = 0 ; b < photo[a].length ; b++) 
        		sum += point.get(photo[a][b]) == null ? 0 : point.get(photo[a][b]);
        	
        	result[a] = sum;
        }

        return result;
    }

}
