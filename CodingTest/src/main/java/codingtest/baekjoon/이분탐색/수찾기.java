package codingtest.baekjoon.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {

	public static void main(String[] args) {
		
//		5
//		4 1 5 2 3
//		5
//		1 3 7 9 5
		
//		1
//		1
//		0
//		0
//		1
		
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		
		//기준 수
		int N = sc.nextInt();
		int[] nArr = new int[N];
		for(int a = 0 ; a < N ; a++) nArr[a] = sc.nextInt();
		
		//배열은 반드시 정렬되어 있어야 한다.
		Arrays.sort(nArr);
		
		//포함 여부 확인
		int M = sc.nextInt();
		for(int b = 0 ; b < M ; b++) {
			
			int key 		= sc.nextInt();			//비교 수
			int start 		= 0;					//탐색 범위 왼쪽 끝 인덱스
			int end 		= nArr.length - 1;		//탐색 범위 오른쪽 끝 인덱스
			boolean pass	= false;				//값 포함 여부
			
			while(start <= end) {
				
				int mid = (start + end) / 2; 	//중간 위치

				if(key < nArr[mid]) {			//key(찾고자 하는 수) 값이 중간 위치의 값보다 작을 경우
					end = mid -1;
				} else if (nArr[mid] < key) {	//key(찾고자 하는 수) 값이 중간 위치의 값보다 클 경우
					start = mid + 1;
				} else {						//key(찾고자 하는 수) 값이 중간 위치의 값과 같은 경우
					result.append("1").append("\n");
					pass = true;
					break;
				}//end if()
				
			}//end while()
			
			if(!pass) result.append("0").append("\n");
		}//end for()
		
		System.out.println(result.toString());
	}//end main()
	
}//end class()
