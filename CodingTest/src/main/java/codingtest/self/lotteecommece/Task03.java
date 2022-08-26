package codingtest.self.lotteecommece;

import java.util.Arrays;

public class Task03 {
	
	public static void main(String[] args) {

//		14524, 24432, 235-12
//		2749 768 24-1
		
		int[] truck		= {1, 4, 5, 2, 4};
		int[] w			= {2, 4, 4, 3, 2};
		
//		int[] truck		= {2, 7, 4, 9};
//		int[] w			= {7, 6, 8};
		
		int[] result 	= solution(truck, w);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	public static int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];
        
        for(int a = 0 ; a < w.length ; a++) {
        	int weight = w[a];
        	
        	int[] newTruck = Arrays.copyOf(truck, truck.length);
        	Arrays.sort(newTruck);
        	int maxWeight = newTruck[newTruck.length - 1];
        	
        	if(weight <= maxWeight) {
        		for(int b = 0 ; b < truck.length ; b++) {
            		int limit = truck[b];

            		if(weight <= limit) {
            			truck[b] = limit - weight;
            			answer[a] = b + 1;
            			break;
            		}//end if()
            			
            	}//end for()
        	} else {
        		answer[a] = -1;
        	}//end if()

        }//end for()
        return answer;
	}//end solution()

}//end class()
