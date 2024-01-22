package codingtest.baekjoon.집합과맵;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 회사에있는사람 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<String> set = new HashSet<>();
		String log = sc.nextLine();
		
		for(int a = 0 ; a < n ; a++) {
			log = sc.nextLine();
			String[] logArr = log.split(" ");
			if("enter".equals(logArr[1])) set.add(logArr[0]);
			else if("leave".equals(logArr[1])) set.remove(logArr[0]);
		}
		
		List<String> result = new ArrayList<>(set);
		Collections.sort(result, Collections.reverseOrder());
		for(String key : result) System.out.println(key);
	}

}
