package codingtest.programmers.dev_matching;

public class Dev_Matching_2022상반기_1 {
	
	public static void main(String[] args) {
		
		
		//int[] grade	= {2, 1, 3};
		int[] grade	= {3, 2, 3, 6, 4, 5};
		int result 	= solution(grade);
		
		System.out.println(result);
	}//end main()
	
    public static int solution(int[] grade) {
        int pointDiff = 0;		//원래 점수와 바뀐 점수의 차이 합
        
        
        for(int a = grade.length - 2 ; 0 <= a ; a--) {
        	int preIndex = (a + 1);
        	int postIndex = a;
        	int dwiNum 	= grade[preIndex];
        	int apNum 	= grade[postIndex];
        	
        	if(dwiNum < apNum) { //성적이 감소하는 경우
        		int diff = apNum - dwiNum;
        		pointDiff += diff;
        		
        		grade[postIndex] = dwiNum;
        	}//end if()
        	
        }//end for()
        
        return pointDiff;
    }//end solution()

}//end class()