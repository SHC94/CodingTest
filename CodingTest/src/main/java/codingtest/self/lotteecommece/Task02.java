package codingtest.self.lotteecommece;

public class Task02 {
	
	public static void main(String[] args) {
		int n		= 9;
		int k		= 3;
		
//		9 3 3
//		10 2 4
//		9 4 0
		int result 	= solution(n, k);
		
		System.out.println(result);
	}//end main()
	
	private static int max = 0;
	private static int answer = 0;
	
	public static int solution(int n, int k) {
        int[] arr 			= new int[n];
        boolean[] visited 	= new boolean[n];
        
        for(int a = 0 ; a < n ; a++) {
        	arr[a] = a + 1;
        }//end for()
        
        max = n;
        combination(arr, visited, 0, arr.length, k);
        
        return answer;
	}//end solution()
	
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
           print(arr, visited, n);
           return;
        }//end if()

        for(int i = start ; i < n ; i++) {
           visited[i] = true;
           combination(arr, visited, i + 1, n, r - 1);
           visited[i] = false;
        }//end for()
     }//end combination()
     
     static void print(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
           if (visited[i]) {
        	   System.out.print(arr[i] + " ");
        	   sum += arr[i];
           }//end if()
           
           if(max < sum) {
        	   System.out.println();
        	   return;
           }
        }//end for()
        System.out.println();
        if(sum == max) answer++;
     }//end print()

}//end class()
