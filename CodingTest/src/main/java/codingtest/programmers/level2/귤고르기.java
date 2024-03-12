package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class 귤고르기 {
	
	public static void main(String[] args) {
		
		// https://school.programmers.co.kr/learn/courses/30/lessons/138476
//		입출력 예제
//		k	tangerine					result
//		6	[1, 3, 2, 5, 4, 5, 2, 3]	3
//		4	[1, 3, 2, 5, 4, 5, 2, 3]	2
//		2	[1, 1, 1, 1, 2, 2, 2, 3]	1

//		int k			= 6;
//		int[] tangerine	= {1, 3, 2, 5, 4, 5, 2, 3};
		int k			= 4;
		int[] tangerine	= {1, 3, 2, 5, 4, 5, 2, 3};
//		int k			= 6;
//		int[] tangerine	= {1, 3, 2, 5, 4, 5, 2, 3};
		int result 		= solution(k, tangerine);
		
		System.out.println(result);
	}//end main()

	public static int solution(int k, int[] tangerine) {
		int sum = 0;
        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        for (int v : valueList) {
            if (sum + v >= k) {
                cnt++;
                break;
            } else {
                sum += v;
                cnt++;
            }
        }
        return cnt;
    }

	private static int result = Integer.MAX_VALUE;
	private static HashSet<Integer> set = new HashSet<>();

	public static int solution2(int k, int[] tangerine) {
		boolean[] visited 	= new boolean[tangerine.length];
		combination(tangerine, visited, 0, tangerine.length, k);
        return result;
    }

	private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			print(arr, visited, n);
			return;
		}

		for(int i = start ; i < n ; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	private static void print(int[] arr, boolean[] visited, int n) {
		set = new HashSet<>();

		for(int i = 0 ; i < n; i++) {
			if(visited[i]) {
				set.add(arr[i]);
				if(result < set.size()) break;
			}
		}

		if(set.size() <= result) result = set.size();
	}

}
