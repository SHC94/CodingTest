package codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 숫자짝꿍 {
	
	public static void main(String[] args) {
		
//		X		Y			result
//		"100"	"2345"		"-1"
//		"100"	"203045"	"0"
//		"100"	"123450"	"10"
//		"12321"	"42531"		"321"
//		"5525"	"1255"		"552"
		
		String X 		= "100";
		String Y		= "203045";
		String result 	= solution(X, Y);
		
		System.out.println(result);
	}//end main()j
	
	public static String solution(String X, String Y) {
		HashMap<String, Integer> xMap = new HashMap<>();
		HashMap<String, Integer> yMap = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        
        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }
        
        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }
        
        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;
            
            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }
        
        String result = list.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
        
        if(result.isEmpty()) return "-1";
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }

}
