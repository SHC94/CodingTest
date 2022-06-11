package codingtest.coupang;

public class SCM_Back_end_Engineer_in_2022_3_reStart1 {
	
	public static void main(String[] args) {
		
		int[][] board		= {	{3, 2, 3, 2},
								{2, 1, 1, 2},
								{1, 1, 2, 1},
								{4, 1, 1, 1}
							};
		
//		int[][] board		= {	{4, 2, 3, 2},
//								{2, 1, 2, 4},
//								{1, 2, 3, 1},
//								{4, 1, 4, 3}
//							};

		/**반례*/
//		int[][] board		= {	{1, 1, 1, 1},
//								{1, 1, 1, 1},
//								{1, 1, 1, 1},
//								{1, 1, 1, 1}
//							};

		
		/**DFS로 풀어볼 것.*/
		int result 			= solution(board);
		
		System.out.println(result);
	}//end main()
	
	static boolean[][] visited;
	static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] map;
	static int result;
	
	public static int solution(int[][] board) {
        int max = -1;
        map = board;
        
        for(int a = 0 ; a < board.length ; a++) {
        	for(int b = 0 ; b < board[a].length ; b++) {
        		System.out.println("=======================");
        		visited = new boolean[map.length][map[0].length];
        		visited[a][b] = true;
        		dfs(a, b, 1);
        	}//end for()
        }//end for()
        
        return result == 1 ? max : result;
	}//end solution()


	private static Integer dfs(int a, int b, int distance) {
		System.out.println("x = " + a + " / y = " + b + " / d = " + distance);
		int start = map[a][b];
		if(result < distance) result = distance;
		
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length -1 < moveX || map[0].length -1 < moveY) continue;
    		if(visited[moveX][moveY]) continue;
    		if(map[moveX][moveY] != start) continue;
			
    		visited[moveX][moveY] = true;
    		dfs(moveX, moveY, distance + 1); 
    		visited[moveX][moveY] = false;	//이걸 몰라서 문제였음. 
		}//end for()
		
		return result;
	}//end dfs()

}//end class()