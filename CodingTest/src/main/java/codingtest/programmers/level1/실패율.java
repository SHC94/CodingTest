package codingtest.programmers.level1;

public class 실패율 {
	
	public static void main(String[] args) {
		
//		numbers				result
//		[1,2,3,4,6,7,8,0]	14
//		[5,8,4,0,6,7,9]		6
		
		int[] numbers	= {1,2,3,4,6,7,8,0};
		
		int result 		= solution(numbers);
		
		System.out.println(result);
	}//end main()j
	
	public static int solution(int[] numbers) {
        int answer = 45;
        
        for(int a = 0 ; a < numbers.length ; a++) answer -= numbers[a];
        
        return answer;
    }//end solution()

}//end class()
