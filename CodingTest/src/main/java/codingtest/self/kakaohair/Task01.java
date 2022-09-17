package codingtest.self.kakaohair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Task01 {
	
	private static HashSet<Integer> result = new HashSet<>();
	private static Long answer = 0L;
	private static boolean pass = false;
	
	public static void main(String[] args) {
		
		//4, 	9
		//11, 31
		int n = 11;
		long result = solution(n);
		System.out.println(result);
	}

	private static long solution(long n) {
		List<Integer> threeList = new ArrayList<Integer>();
		
		/** 1. 3의 거듭제곱을 구한다. (n 제곱 까지)*/
		for(int a = 0 ; a <= n ; a++) {
			threeList.add((int) Math.pow(3, a));
			result.add((int) Math.pow(3, a));
			
			boolean[] visited = new boolean[threeList.size()];
			
			for(int b = 2 ; b <= n ; b++) {
				
				combination(threeList, visited, 0, threeList.size(), b);	
				
				if(result.size() >= n * n) break;
			}//end for()
			
		}//end for()
		
		/**결과 추출*/
		ArrayList<Integer> sortList = new ArrayList<>(result);
        Collections.sort(sortList);
        
		answer = (long) sortList.get((int) (n - 1));
		
		return answer;
	}//end solution()
	
	public static void combination(List<Integer> threeList, boolean[] visited, int start, int n, int r) {
		
		if (r == 0) {
			print(threeList, visited, n);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(threeList, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}//end combination()

	public static void print(List<Integer> threeList, boolean[] visited, int n) {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				sum += threeList.get(i);
				System.out.print(threeList.get(i) + "\t");
			}//end if()
		}//end for()

		System.out.println();
		result.add(sum);
	}//end print()
      
}//end main()
