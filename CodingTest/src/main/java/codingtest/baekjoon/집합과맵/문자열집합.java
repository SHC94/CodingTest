package codingtest.baekjoon.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st 	= new StringTokenizer(br.readLine());
        
        int N 		= Integer.parseInt(st.nextToken());
        int M 		= Integer.parseInt(st.nextToken());
        int result 	= 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < N ; i++) 
        	map.put(br.readLine(), 0);
        
        for(int i = 0 ; i < M ; i++) 
        	if (map.containsKey(br.readLine())) result++;
        
        System.out.print(result);
	}

}
