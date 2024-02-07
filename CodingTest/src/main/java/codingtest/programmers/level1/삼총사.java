package codingtest.programmers.level1;

public class 삼총사 {
	
	public static void main(String[] args) {

		// https://school.programmers.co.kr/learn/courses/30/lessons/131705
//		입출력 예
//		number						result
//		[-2, 3, 0, 2, -5]			2
//		[-3, -2, -1, 0, 1, 2, 3]	5
//		[-1, 1, -1, 1]				0

		int[] number	= {-2, 3, 0, 2, -5};
		int result 		= solution(number);
		
		System.out.println(result);
//		System.out.println(Arrays.toString(result));
	}
	
	
	private static int result = 0;
	
	public static int solution(int[] number) {
		boolean[] visited = new boolean[number.length];
		// combination(arr, visited, 0, n, r)
        combination(number, visited, 0, number.length, 3);
        return result;
    }

	private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	print(arr, visited, n);
	        return;
	    } 

	    for(int i = start ; i < n ; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}

	private static void print(int[] arr, boolean[] visited, int n) {
		int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        if(sum == 0) result++;
    }
	

}
