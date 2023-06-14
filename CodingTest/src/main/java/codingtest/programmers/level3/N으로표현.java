package codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {
	
	public static void main(String[] args) {
				
//		N	number	return
//		5	12		4
//		2	11		3
				
		int N		= 5; 
		int number	= 12;
		int result 	= solution(N, number);
		
		System.out.println(result);
	}//end main()
	
	public static int solution(int N, int number) {
		List<Set<Integer>> list = new ArrayList<>();

		//set 객체 생성
        for(int i = 0 ; i < 9 ; i++) list.add(new HashSet<>());
        
        // N을 1개 쓴 값은 N 혼자이다.
        list.get(1).add(N); 
        
        for(int i = 2 ; i < 9 ; i++){
            Set<Integer> countSet = list.get(i); 

            for(int j = 1 ; j <= i ; j++){
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);

                for(int preNum : preSet){
                    for(int postNum : postSet){
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if(preNum != 0 && postNum != 0) countSet.add(preNum / postNum);
                    }//end for()
                }//end for()
            }//end for()
        }//end for()

        for(Set<Integer> sub : list){
        	
            if(sub.contains(number)) return list.indexOf(sub);
            
        }//end for()

        return -1;
	}//end solution()
	
}//end class()