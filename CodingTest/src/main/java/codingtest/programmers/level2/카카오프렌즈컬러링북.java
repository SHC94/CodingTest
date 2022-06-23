package codingtest.programmers.level2;

import java.util.Arrays;

public class 카카오프렌즈컬러링북 {
	
	private static int[][] map;				//전체 맵
	private static boolean[][] visited;		//방문 여부
	private static int maxArea 		= 0;									//영역별 칸의 갯수
	private static int[][] pattern 	= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};	//이동 경로
	
	public static void main(String[] args) {
		
//		m	n	picture	
//		6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	

//		answer
//		[4, 5]
				
		int m			= 6;
		int n 			= 4;
		int[][] picture	= {	{1, 1, 1, 0}, 
							{1, 2, 2, 0}, 
							{1, 0, 0, 1}, 
							{0, 0, 0, 1}, 
							{0, 0, 0, 3}, 
							{0, 0, 0, 3}};
		
//		int[][] picture	= {	{0, 0, 0, 0}, 
//							{0, 0, 0, 0}, 
//							{0, 0, 0, 0}, 
//							{0, 0, 0, 0}, 
//							{0, 0, 0, 0}, 
//							{0, 0, 0, 0}};
		
		int[] result 	= solution(m, n, picture);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	
	public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int areaCnt 	= 0;
        int result 		= 0;
        //맵 전역 변수 전환
        map = picture;
        visited = new boolean[m][n];
        
        //그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.
        for(int a = 0 ; a < map.length ; a++) {
        	for(int b = 0 ; b < map[a].length ; b++) {
        		//방문한 적이 없고, 공백인 칸이 아닌 경우 탐색 시작
            	if(!visited[a][b] && map[a][b] != 0) {
            		
            		dfs(a, b);
            		areaCnt++;
            		
            	}//end if()
            	
            	if(result < maxArea) result = maxArea;
            	maxArea = 0;
            }//end for()
        }//end for()
        
        answer[0] = areaCnt;
        answer[1] = result;
        return answer;
	}//end solution()


	private static void dfs(int a, int b) {
		//방문 여부 체크
		visited[a][b] = true;
		maxArea++;
		
		//다음 경로 이동
		for(int i = 0 ; i < pattern.length ; i++) {
			int moveX = a + pattern[i][0];
			int moveY = b + pattern[i][1];
			
			//맵 범위를 넘어선 경우 
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			
			//방문했던 경로인 경우
			if(visited[moveX][moveY]) continue;
			
			//다른 영역인 경우
			if(map[a][b] != map[moveX][moveY]) continue;
			
			dfs(moveX, moveY);
		}//end for()
		
	}//end dfs()

}//end class()
