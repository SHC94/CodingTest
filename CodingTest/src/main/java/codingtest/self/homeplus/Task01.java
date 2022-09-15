package codingtest.self.homeplus;

public class Task01 {
	
	public static void main(String[] args) {

		int[][] office	= {{1,0,0,0}, {0,0,0,1}, {0,0,1,0}, {0,1,1,0}};
		int k			= 2;
		
		int result 		= solution(office, k);
		
		System.out.println(result);
	}//end main()
	
	public static int solution(int[][] office, int k) {
        int max 	= 0;
        int result 	= Integer.MIN_VALUE;
        
        for(int a = 0 ; a < office.length - 1 ; a++) {
        	for(int b = 0 ; b < office[a].length - 1 ; b++) {
        		max 	= 0;
        		
        		if(((a == 0 || b == 0)) || ((a == office.length - 2 || b == office[0].length - 2))) {
        			for(int c = a ; c < a + k ; c++) {
                		for(int d = b ; d < b + k ; d++) {

                    		if(office[c][d] == 1) max++;
                    		
                    	}//end for()
                	}//end for()
        		}//end if()
        		
            	if(result < max) result = max;
            }//end for()
        	
        }//end for()
        
        return result;
	}//end solution()

}//end class()
