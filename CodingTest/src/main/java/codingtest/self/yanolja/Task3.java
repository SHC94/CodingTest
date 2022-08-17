package codingtest.self.yanolja;

import java.util.Arrays;

public class Task3 {

	//1...N 정수로 구성된 배열 A
	
	//한번의 이동으로 모든 요소의 값을 1씩 늘리거나 줄일수 있어야 한다.
	
	//이동 후 모든 숫자는 1...N 범위 내에 있어야 한다.
	
	//배열의 모든 요소를 쌍으로 구별하기 위해 필요한 최소 이동 수를 찾는 것.
	
	//N개의 정수로 구성된 배열 A가 주어지면 배열의 모든 요소를 쌍으로 구별하는데 필요한 최소 이동 횟수를 반환한다.
	//결과가 1,000,000,000보다 크면 함수는 -1을 반호나해야합니다.
	
	
	//ex
	//{1, 2, 1} >> result 2
	//{1,2,1} >> {1,2,2} >> {1,2,3}
	
	public static void main(String[] args) {
		
		int[] A = {6, 2, 3, 5, 6, 3};
		
		int result = solution(A);
		
		System.out.println("result = " + result);
	}

	private static int solution(int[] A) {
		int result 		= 0;	//결과
		int standardNum = 0; 	//조건에 맞게 나와야하는 수들의 합
		for(int i = 1 ; i <= A.length ; i++) standardNum += i;
		
		//주어진 수들의 합
		int compareNum = Arrays.stream(A).sum();
		
		//기준과 주어진 수들의 합 차이가 이동 횟수.
		result = Math.abs(standardNum - compareNum);
		return result;
	}//end solution()
	
}//end class()
