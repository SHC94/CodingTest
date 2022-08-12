package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 전력망을둘로나누기 {

	public static void main(String[] args) {

//		n	wires												result
//		9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
//		4	[[1,2],[2,3],[3,4]]									0
//		7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]				1

		int n			= 9; 
		int[][] wires	= {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

		int result 		= solution(n, wires);

		System.out.println(result);
	}// end main()

	public static int solution(int n, int[][] wires) {

		int answer = n;

		HashMap<Integer, List<Integer>> group = new HashMap<>();
		for (int wire[] : wires) {
			groupping(group, wire, 0, 1);
			groupping(group, wire, 1, 0);
		}//end for()

		int cursor = 0;
		while (cursor < wires.length) {
			int noMember[] = wires[cursor];
			for (Integer me : group.keySet()) {
				HashMap<Integer, Boolean> newGroup = new HashMap<>();
				if (me != noMember[0] && me != noMember[1]) {
					makeLine(noMember, group, me, newGroup);

					int sum = Math.abs(newGroup.size() - Math.abs(newGroup.size() - n));
					if (sum < answer)
						answer = sum;
					continue;

				}//end if()
			}//end for()
			cursor++;
		}//end while()
		return answer;
	}//end solution()
	
	private static void makeLine(int noMember[], HashMap<Integer, List<Integer>> group, int me, HashMap<Integer, Boolean> newGroup) {

		List<Integer> list = group.get(me);
		for (int target : list) {
			if (me == noMember[0] || me == noMember[1]) {
				if (target == noMember[0] || target == noMember[1]) {
					newGroup.put(me, true);
					continue;
				}//end if()
			}//end if()
			
			if (newGroup.get(target) == null) {
				newGroup.put(target, true);
				makeLine(noMember, group, target, newGroup);
			}//end if()
		}//end for()

	}//end makeLine()

	private static void groupping(HashMap<Integer, List<Integer>> group, int wire[], int target, int value) {
		List<Integer> set;
		if (group.get(wire[target]) == null) {
			set = new ArrayList<>();
			set.add(wire[value]);
			group.put(wire[target], set);
		} else {
			set = group.get(wire[target]);
			boolean isAdd = true;
			for (int num : set) {
				if (num == wire[value]) {
					isAdd = false;
					break;
				}//end if()
			}//end for()
			if (isAdd) {
				set.add(wire[value]);
			}//end if()
		}//end if()
	}//end groupping()
	
}//end class()
