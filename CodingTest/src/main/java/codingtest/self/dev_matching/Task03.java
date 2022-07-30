package codingtest.self.dev_matching;

import java.util.Arrays;

public class Task03 {
	
	public static void main(String[] args) {
		
		
		int[][] lands = {{}};
		int[] result 			= solution(9, 7, lands);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	private static int[][] map;
    private static boolean[][] visited;
    private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int area = 0;
    
    public static int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = new int[2];
        Arrays.fill(answer, -1);

        //전체 맵 크기 설정
        map     = new int[rows][columns];
        visited = new boolean[rows][columns];

        //땅 : 1
        //바다 : 9
        //호수 : 0

        //땅 설정
        for(int a = 0 ; a < lands.length ; a++) {
            int x = lands[a][0];
            int y = lands[a][1];
            map[x - 1][y - 1] = 1;
        }//end for()

        //바다 설정
        map[0][0] = 9;
        dfs(0, 0, true);

        visited = new boolean[rows][columns];

        //호수 찾기
        for(int a = 0 ; a < map.length ; a++) {
            for(int b = 0 ; b < map[a].length ; b++) {
                area = 1;

                //방문하지 않았던 호수
                if(!visited[a][b] && map[a][b] == 0) {
                    dfs(a, b, false);

                    if(area < min) min = area;
                    if(max < area) max = area;
                    answer[0] = min;
                    answer[1] = max;
                }//end if()

            }//end for()
        }//end for()
        
        return answer;
    }//end solution()

    private static void dfs(int x, int y, boolean pass) {
        visited[x][y] = true;

        for(int a = 0 ; a < pattern.length ; a++) {
            int moveX = x + pattern[a][0];
            int moveY = y + pattern[a][1];

            //맵 범위를 넘어선 경우
            if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;

            //방문했던 곳인 경우
            if(visited[moveX][moveY]) continue;

            //땅인 경우
            if(map[moveX][moveY] == 1) continue;

            if(pass) map[moveX][moveY] = 9;
            if(!pass)  area = area + 1;
            
            dfs(moveX, moveY, pass);
        }//end for()

    }//end dfs()
}//end class()