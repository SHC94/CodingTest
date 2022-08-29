package codingtest.self.foodtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Task02 {
	
	public static void main(String[] args) {
		
		int[] arr 	= {2, 1, 3, 1, 4, 2, 1, 3}; 
		//int[] arr 	= {1, 2, 3};
		int result 	= solution(arr);
		
		System.out.println(result);
	}//end main()
	
	private static HashMap<Integer, List<Integer>> map = new HashMap<>();
	private static int result = Integer.MAX_VALUE;
	
	public static int solution(int[] arr) {
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int a = 0 ; a < arr.length ; a++) set.add(arr[a]);
		
		if(arr.length == set.size()) {	//중복 당첨 고객이 없는 경우
			
			return -1;
			
		} else {
			//당첨자 걸러내기
			winFilter(arr);
			
			//가장 빨리 중복 당첨 찾기
			fastWinFilter();
		}//end if()
		
        return result;
	}//end solution()

	private static void fastWinFilter() {
		
		for(int key : map.keySet()) {
			
			List<Integer> list = map.get(key);
			
			if(1 < list.size()) {
				for(int a = 0 ; a < list.size() - 1 ; a++) {
					int x = list.get(a);
					int y = list.get(a + 1);
					int dis = y - x;
					
					if(dis < result) result = dis;
				}//end for()
			}//end if()
			
		}//end for()
		
	}//end overlapWinFilter()

	private static void winFilter(int[] arr) {
		int time = 1;
		
		//하루씩 체크
		for(int a = 0 ; a < arr.length ; a++) {
			int winCustomer = arr[a];
			List<Integer> list;
			
			if(!map.containsKey(winCustomer)) list = new ArrayList<Integer>();	//최초 당첨된 경우
			else list = map.get(winCustomer);									//이미 당첨된 적이 있는 경우
			
			list.add(time);
			map.put(winCustomer, list);
			
			time++;
		}//end for()
	}//end winFilter()
	
}//end class()