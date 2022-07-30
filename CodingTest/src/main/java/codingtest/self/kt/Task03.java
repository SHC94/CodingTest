package codingtest.self.kt;

public class Task03 {
	
	public static void main(String[] args) {
		
		//int[][] board = {{1, 2}, {3, 4}};
		int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int result = solution(board);
		
		System.out.println(result);
	}//end main()
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int result = Integer.MIN_VALUE;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static int solution(int[][] board) {
		
		map 	= new int[board.length][board[0].length];
		visited = new boolean[board.length][board[0].length];
		
		for(int a = 0 ; a < board.length ; a++) {
			for(int b = 0 ; b < board[a].length ; b++) {
				map[a][b] = board[a][b];
			}//end for()
		}//end for()
		
		visited[0][0] = true;
		System.out.println(0 + ", " + 0 + ", " + map[0][0]);
		dfs(0, 0, map[0][0]);
		
		return result;
	}//end solution()

	private static void dfs(int x, int y, int cookie) {
		
		if(result < cookie) result = cookie;
		if(x == (map.length - 1) && (y == (map[0].length - 1))) return;
			
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = x + pattern[i][0];
			int moveY = y + pattern[i][1];
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(visited[moveX][moveY]) continue;
			
			int thisCookie = map[moveX][moveY];
			System.out.println(moveX + ", " + moveY + ", " + (cookie + thisCookie));
			visited[moveX][moveY] = true;
			dfs(moveX, moveY, (cookie + thisCookie));
			System.out.println("=================================");
			visited[moveX][moveY] = false;
			
		}//end for()
		
	}//end dfs()
	
}//end class()