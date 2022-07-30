package codingtest.self.kt;

import java.util.Arrays;

public class Task01 {
	
	public static void main(String[] args) {
		
		//int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = {{1, 2, 1}, {2, 3, 1}, {3, 2, 1}};
		int[][] result = solution(matrix);
		
		for(int a = 0 ; a < result.length ; a++) {
			System.out.println(Arrays.toString(result[a]));
		}//end for()
		
	}//end main()
	
	public static int[][] solution(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix[0].length];
		
		for(int i = 0 ; i < matrix.length ; i++){
			
            for(int j = 0 ; j < matrix[0].length ; j++){
            	
            	int sum = -1 * matrix[i][j];
            	
                for(int k = 0 ; k < matrix[0].length ; k++) {
                	
                	sum += matrix[i][k];
                	sum += matrix[k][j];
                	
                }//end for()
                result[i][j] = sum;
                
            }//end for()
            
        }//end for()
		
		return result;
	}//end solution()
	
}//end class()