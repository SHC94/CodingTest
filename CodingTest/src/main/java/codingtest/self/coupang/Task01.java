package codingtest.self.coupang;

import java.util.*;

public class Task01 {
	
	public static void main(String[] args) {

//		int n				= 6;
//		int[][] delivery	= {	{1,3,1},
//								{3,5,0},
//								{5,4,0},
//								{2,5,0},
//							};
		
		
		int n				= 7;
		int[][] delivery	= {	{5,6,0},
								{1,3,1},
								{1,5,0},
								{7,6,0},
								{3,7,1},
								{2,5,0}
							};
		String result 		= solution(n, delivery);
		
		System.out.println(result);
	}//end main()
	
	public static String solution(int n, int[][] delivery) {
        String[] result = new String[n];
        Arrays.fill(result, "?");
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        
        for(int a = 0 ; a < delivery.length ; a++) {
        	int firstProduct 	= delivery[a][0];
        	int secondProduct 	= delivery[a][1];
        	int deliveryYn		= delivery[a][2];
        	
        	//1. 배송이 나감으로써 둘다 재고가 있는 경우에 대해서 판단
        	if(deliveryYn == 1) { 				//배송 나감 (둘다 재고가 있음.)
        		map.put(firstProduct, "O");
        		map.put(secondProduct, "O");
        	} else { 							//배송 못 나감 (두 상품 중 하나라도 문제가 있음.)
        		//둘 중에 하나라도 재고 있는 경우, 나머지 하나는 재고가 없음.
        		if(map.containsKey(firstProduct) && map.get(firstProduct) == "O") {
        			map.put(secondProduct, "X");
        			continue;
        		}//end if()
        		if(map.containsKey(secondProduct) && map.get(secondProduct) == "O") {
        			map.put(firstProduct, "X");
        			continue;
        		}//end if()

        	}//end if()
        }//end for()
        
        for(int a = 0 ; a < delivery.length ; a++) {
        	int firstProduct 	= delivery[a][0];
        	int secondProduct 	= delivery[a][1];
        	int deliveryYn		= delivery[a][2];
        	
        	if(deliveryYn == 0) {
        		if(map.containsKey(firstProduct) && map.get(firstProduct) == "O") {
        			map.put(secondProduct, "X");
        			continue;
        		}//end if()
        		if(map.containsKey(secondProduct) && map.get(secondProduct) == "O") {
        			map.put(firstProduct, "X");
        			continue;
        		}//end if()
        	}
        }//end for()
        
        for(int key : map.keySet()) {
        	String value = map.get(key);
        	result[key - 1] = value;
        }//end for()
        
        StringBuilder sb = new StringBuilder();
        for(String resultStr : result) sb.append(resultStr);
        
        return sb.toString();
	}//end solution()

}//end class()
