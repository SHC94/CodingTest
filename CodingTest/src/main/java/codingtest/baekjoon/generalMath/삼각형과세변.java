package codingtest.baekjoon.generalMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class 삼각형과세변 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		
		while(true) {
			int a	= sc.nextInt();
			int b	= sc.nextInt();
			int c 	= sc.nextInt();
			
			if(a == 0 && b == 0 && c == 0) break;
			
			List<Integer> list = new ArrayList<>();
			list.add(a);
			list.add(b);
			list.add(c);
			Collections.sort(list);
			
			if(list.get(0) + list.get(1) <= list.get(2)) {
				
				System.out.println("Invalid");
				
			} else {
				
				HashMap<Integer, Integer> map = new HashMap<>();
				if(Objects.isNull(map.get(a))) map.put(a, 1);
				else map.put(a, map.get(a) + 1);
				if(Objects.isNull(map.get(b))) map.put(b, 1);
				else map.put(b, map.get(b) + 1);
				if(Objects.isNull(map.get(c))) map.put(c, 1);
				else map.put(c, map.get(c) + 1);
				
				if(map.size() == 1) System.out.println("Equilateral");
				else if(map.size() == 2) System.out.println("Isosceles");
				else if(map.size() == 3) System.out.println("Scalene");
				
			}
			
		}
		
    }

}
