package codingtest.baekjoon.BFS_DFS;

import java.util.Arrays;
import java.util.Scanner;

public class 단지번호붙이기_X {

	private static int[][] pattern = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	private static int apartNum = 0;	
	private static boolean[][] visited;
	private static int[][] map;
	private static int[] aparts 		= new int[25*25];
	
	public static void main(String[] args) {
		
		Scanner sc 	= new Scanner(System.in);
		int N 		= sc.nextInt();
		map 		= new int[N][N];
		visited		= new boolean[N][N];
		
		//맵 데이터 세팅
		for(int a = 0 ; a < N ; a++) {
			String str = sc.next();
			for(int b = 0 ; b < str.length() ; b++) {
				map[a][b] = Character.getNumericValue(str.charAt(b));
			}//end for()
		}//end for()
		
		//맵 확인
		for(int a = 0 ; a < N ; a++) {
			for(int b = 0 ; b < N ; b++) {
				System.out.print(map[a][b] + "\t");
			}//end for()
			System.out.println();
		}//end for()
		
		for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    dfs(i,j);
                }//end if()
            }//end for()
        }//end for()

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for(int i=0; i<aparts.length; i++){
            if(aparts[i] != 0){
            	System.out.println(aparts[i]);
            }//end if()
        }//end for()
		
	}//end main()
	
	private static void dfs(int a, int b) {
		
        aparts[apartNum]++;
		
		for(int i = 0 ; i < pattern.length ; i++) {
			//이동할 위치
			int moveX = pattern[i][0] + a;
			int moveY = pattern[i][1] + b;
			
			if(moveX < 0 || moveY < 0 || map.length - 1 < moveX || map[0].length - 1 < moveY) continue;
			if(visited[moveX][moveY]) continue;
			if(map[moveX][moveY] == 0) continue;
			
			visited[moveX][moveY] = true;
			dfs(moveX, moveY);
			visited[moveX][moveY] = false;
		}//end for()
			
	}//end dfs()
	
}//end class()

