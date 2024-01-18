package codingtest.baekjoon.이분탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가장긴증가하는부분수열3 {

	public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		int N 				= sc.nextInt();
        List<Integer> list 	= new ArrayList<>();
        int arr[] 			= new int[N + 1];
        list.add(Integer.MIN_VALUE);
        
        for(int i = 1 ; i <= N; i++) arr[i] = sc.nextInt();

        

        for(int i = 1 ; i <= N; i++){
            int num 	= arr[i];
            int left 	= 1;
            int right 	= list.size() - 1;

            if(num > list.get(list.size() - 1)) {
            	list.add(num);
            } else {
            	
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }//end while()
                
                list.set(right, num);
            }//end if()
        }//end for()

        System.out.println(list.size() - 1);
	}//end main()
	
}//end class()