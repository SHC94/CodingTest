package codingtest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {

//		bridge_length	weight	truck_weights					return
//		2				10		[7,4,5,6]						8
//		100				100		[10]							101
//		100				100		[10,10,10,10,10,10,10,10,10,10]	110

		int bridge_length	= 100;
		int weight 			= 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		int result 			= solution(bridge_length, weight, truck_weights);

		System.out.println(result);
	}// end main()

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue 	= new LinkedList<>();
		int sum 				= 0;
		int time 				= 0;

		for (int i = 0; i < truck_weights.length; i++) {
			int truck = truck_weights[i];

			while (true) {
				//다리 위에 트럭이 없는 경우
				if (queue.isEmpty()) {
					queue.add(truck);
					sum += truck;
					time++;
					break;
					
				//다리 위 트럭이 가득 들어선 경우
				} else if (queue.size() == bridge_length) {
					sum -= queue.poll();
				
				//다리 길이만큼 트럭이 들어서지 않은 경우
				} else {
					if (sum + truck <= weight) {
						queue.add(truck);
						sum += truck;
						time++;
						break;
					} else {
						queue.add(0);
						time++;
					}//end if()
				}//end if()
			}//end while()
		}//end for()

		return time + bridge_length;
	}//end solution()

}// end class()
