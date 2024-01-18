package codingtest.baekjoon.이분탐색;

import java.util.Scanner;

public class 게임 {

	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);

		Long X 	= sc.nextLong();	//게임 횟수
		Long Y 	= sc.nextLong();	//이긴 게임
		Long Z 	= Y * 100 / X;		//승률
		
		if(99 <= Z) {
			System.out.println(-1); 
		} else {
			
			//게임을 최소 몇판을 더해야 승률이 변하는지?
			Long start 	= 1L; 
			Long end 	= X;
			
			Long addZ	= 0L;				//변경된 승률
			Long mid	= 0L;
			while(start <= end) {
				mid = (start + end) / 2;			//추가 게임
				addZ = (Y + mid) * 100 / (X + mid);	//승률
				
//				System.out.println("추가 게임 = " + mid + " / 전체 게임 = " + addX + " / 이긴 게임 = " + addY + " / 승률 = " + addZ);
				
				if(Z < addZ) {			//승률이 더 높은 경우 판수를 줄여본다.
					end = mid - 1;
				} else  {				//승률이 더 낮거나(이런 경우는 없음) 같은 경우 판수를 늘려본다.
					start = mid + 1;
				}
			}//end while()
			
			System.out.println(start);
			
		}//end if()
		
	}//end main()
	
}//end class()