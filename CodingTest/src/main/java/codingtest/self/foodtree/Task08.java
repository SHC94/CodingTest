package codingtest.self.foodtree;

import java.util.HashMap;

public class Task08 {
	
	public static void main(String[] args) {
		
		solution();
		
	}//end main()
	
	public static void solution() {
		HashMap map = new HashMap();
		map.put(1, "kim");
		map.put(1, "lee");
		map.put(1, "jung");
		map.put(1, "park");
		
		System.out.println(map.size());
		System.out.println(map.get(1));
	}//end solution()
	
}//end class()