package codingtest.baekjoon.generalMath;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class 삼각형외우기 {

	public static void main(String[] args) {
		
		Scanner sc 		= new Scanner(System.in);
		int a 			= sc.nextInt();
		int b			= sc.nextInt();
		int c 			= sc.nextInt();
		
//		세 각의 크기가 모두 60이면, Equilateral
		if(a == 60 && b == 60 && c == 60) {
			System.out.println("Equilateral");
			
//		세 각의 합이 180이고, 
		} else if ((a + b + c) == 180){
			HashMap<Integer, Integer> map = new HashMap<>();
			
			if(Objects.isNull(map.get(a))) map.put(a, 1);
			else map.put(a, map.get(a) + 1);
			if(Objects.isNull(map.get(b))) map.put(b, 1);
			else map.put(b, map.get(b) + 1);
			if(Objects.isNull(map.get(c))) map.put(c, 1);
			else map.put(c, map.get(c) + 1);
			
			// 두 각이 같은 경우에는 Isosceles
			// 같은 각이 없는 경우에는 Scalene
			if(map.size() == 2) System.out.println("Isosceles");
			else System.out.println("Scalene");
			
//		세 각의 합이 180이 아닌 경우에는 Error
		} else if ((a + b + c) != 180) {
			System.out.println("Error");
		}
		
    }

}
