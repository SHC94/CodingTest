package codingtest.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
	
	public static void main(String[] args) {
				
//		board																					result
//		[[0,0,0],[0,0,0],[0,0,0]]																900
//		[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]	3800
//		[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]												2100
//		[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]	3200
				
		int[][] board		= {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//		int[][] board		= {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};

		int result 			= solution(board);
		
		System.out.println(result);
	}//end main()
	
//	경주로의 출발점은 (0, 0) 칸(좌측 상단)이며, 도착점은 (N-1, N-1) 칸(우측 하단)입니다. 죠르디는 출발점인 (0, 0) 칸에서 출발한 자동차가 도착점인 (N-1, N-1) 칸까지 무사히 도달할 수 있게 중간에 끊기지 않도록 경주로를 건설해야 합니다.
//	경주로는 상, 하, 좌, 우로 인접한 두 빈 칸을 연결하여 건설할 수 있으며, 벽이 있는 칸에는 경주로를 건설할 수 없습니다.
//	
//	이때, 인접한 두 빈 칸을 상하 또는 좌우로 연결한 경주로를 직선 도로 라고 합니다.
//	또한 두 직선 도로가 서로 직각으로 만나는 지점을 코너 라고 부릅니다.
//	
//	예를 들어, 아래 그림은 직선 도로 6개와 코너 4개로 구성된 임의의 경주로 예시이며, 건설 비용은 6 x 100 + 4 x 500 = 2600원 입니다.
//	
//	도면의 상태(0은 비어 있음, 1은 벽)을 나타내는 2차원 배열 board가 매개변수로 주어질 때, 경주로를 건설하는데 필요한 최소 비용을 return 하도록 solution 함수를 완성해주세요.
	
	private static boolean[][] visited;
	private static int[][] map;
	private static int[][] pattern 	= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int result 		= Integer.MAX_VALUE;
	
	public static int solution(int[][] board) {
        int answer 	= 0;
        visited 	= new boolean[board.length][board[0].length];
        map			= board;
        
        bfs();
        
        return result;
	}//end solution()

	private static void bfs() {
		Queue<Race> queue = new LinkedList<Race>();
		queue.add(new Race(0, 0, -1, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Race road = queue.poll();

            int x = road.x;
            int y = road.y;
            int dis = road.dis;
            int cost = road.cost;

            if (x == map.length - 1 && y == map.length - 1) {
            	result = Math.min(result, cost);
            }//end if()

            for (int i = 0 ; i < pattern.length ; i++) {
                int moveX 		= x + pattern[i][0];
                int moveY 		= y + pattern[i][1];
                int moveDis 	= i;
                int moveCost 	= cost;

                if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
                if(map[moveX][moveY] == 1) continue;
                
                if (dis == -1) moveCost += 100; 			//최초
                else if (dis == moveDis) moveCost += 100; 	//방향이 같은 경우
                else moveCost += 600; 						//방향이 다른 경우

                if (!visited[moveX][moveY] || moveCost <= map[moveX][moveY]) {
                	visited[moveX][moveY] = true;
                    map[moveX][moveY] = moveCost;
                    queue.add(new Race(moveX, moveY, moveDis, moveCost));
                }//end if()

            }//end for() 
			
		}//end while()
		
	}//end bfs()
	
}//end class()

class Race {
	int x;
	int y;
	int dis;
	int cost;
	
	public Race(int x, int y, int dis, int cost) {
		this.x 		= x;
		this.y 		= y;
		this.dis 	= dis;
		this.cost 	= cost;
	}
}