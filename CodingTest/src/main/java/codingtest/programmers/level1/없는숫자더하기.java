package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 없는숫자더하기 {
	
	public static void main(String[] args) {
		
//		N	stages						result
//		5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
//		4	[4,4,4,4,4]					[4,1,2,3]
		
//		실패율은 다음과 같이 정의한다.
//		스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
		
		int N			= 5;
		int[] stages	= {2, 1, 2, 6, 2, 4, 3, 3};
		
		int[] result 		= solution(N, stages);
		
		System.out.println(Arrays.toString(result));
	}//end main()j
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Double> resultMap = new HashMap<Integer, Double>();
        
        for(int stage : stages) list.add(stage);
        
        Collections.sort(list);
        
        for(int a = 1 ; a <= N ; a++) {
        	int total = list.size();
        	int index = list.lastIndexOf(a);
        	index++;
        	
        	System.out.println(a + " =>> " + index + " / " + total + " = " + (double)index/total);
        	for(int b = 0 ; b < index ; b++) list.remove(0);
        	
        	resultMap.put(a, (double)index/total);
        }//end for()
        
        System.out.println(resultMap.toString());
        
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(resultMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
        	return (int) (o2.getValue() - o1.getValue());
            }
        });
        for(Entry<Integer, Double> entry : entryList){
        	System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }
        
        
        return answer;
    }//end solution()

}//end class()
