package codingtest.baekjoon.Eratosthenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소수의연속합 {

	public static void main(String[] args) {
	    Scanner sc 	= new Scanner(System.in);
	    int n 		= sc.nextInt();
	    List<Integer> primes 	= new ArrayList<>();
	    boolean[] primeNumcheck = new boolean[n+1];
 
        primeNumcheck[0] = true;
        primeNumcheck[1] = true;
        
		for(int i = 2 ; (i * i) <= n ; i++){
            if(!primeNumcheck[i]){
                for (int j = (i * i) ; j <=n ; j += i) {
                    primeNumcheck[j]=true;
                }//end for()
            }//end if()
        }//end for()
		
        for (int i = 1; i <= n ; i++) {
            if(!primeNumcheck[i]){
                primes.add(i);
            }//end if()
        }//end for()
 
        int start 	= 0;
        int end 	= 0;
        int sum 	= 0;
        int count 	= 0;
        while (true){
            if(sum >= n){
                sum -= primes.get(start++);
            } else if(end == primes.size()){
                break;
            } else {
                sum += primes.get(end++);
            }//end if()
            
            if(n==sum){
                count++;
            }//end if()
        }//end while()
 
        System.out.println(count);
 
	}//end main()
	
}//end class()
