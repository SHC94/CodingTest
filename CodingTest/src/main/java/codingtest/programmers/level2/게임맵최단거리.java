package codingtest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
	
	public static void main(String[] args) {
		
		
//		maps															answer
//		[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
//		[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1

//		0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
//		캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
		
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
				
		int result 		= solution(maps);
		
		System.out.println(result);
	}//end main()
	
	public static int solution(int[][] maps) {
        int answer = -1;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(0, 0, 1));
        
        int[][] pattern			= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        boolean[][] visited 	= new boolean[maps.length][maps[0].length];
        visited[0][0] 			= true;
        
        while(!queue.isEmpty()) {
        	
        	Coordinate coordinate = queue.poll();
        	int x = coordinate.x;
        	int y = coordinate.y;
        	int distance = coordinate.distance;
        	
        	if(x == maps.length - 1 && y == maps[0].length - 1) {
        		answer = distance;
        		break;
        	}
        	for(int a = 0 ; a < pattern.length ; a++) {
        		int moveX = pattern[a][0] + x;
        		int moveY = pattern[a][1] + y;
        		
        		if(moveX < 0 || moveY < 0 || maps.length -1 < moveX || maps[0].length -1 < moveY) continue;
        		if(visited[moveX][moveY]) continue;
        		if(maps[moveX][moveY] == 0) continue;
        		
        		visited[moveX][moveY] = true;
        		queue.add(new Coordinate(moveX, moveY, distance + 1));
        	}//end for()
        }//end while()
        
        return answer;
    }//end solution()

}//end class()

class Coordinate {
	int x;
	int y;
	int distance;
	
	public Coordinate(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
}