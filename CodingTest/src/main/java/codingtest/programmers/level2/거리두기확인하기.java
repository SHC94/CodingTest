package codingtest.programmers.level2;

import java.util.Arrays;

public class 거리두기확인하기 {
	
	public static void main(String[] args) {
		
		
//		places	
//		[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]	

//		result
//		[1, 0, 1, 1, 1]
		
//		0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
//		캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
		
		String[][] places	= {	{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
								{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
								{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
								{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
								{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
				
		int[] result 		= solution(places);
		
		System.out.println(Arrays.toString(result));
	}//end main()
	
	private static boolean[][] visited;
	private static String[][] place;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static boolean keepDistance;
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        //대기실 별 이차원 배열 생성
        for(int a = 0 ; a < places.length ; a++) {
        	place 				= new String[5][5];
        	visited				= new boolean[5][5];
        	boolean pass 		= false;				//응시자 존재 여부
        	keepDistance		= true;					//거리두기 여부
        	
        	for(int b = 0 ; b < places[a].length; b++) {
        		String placeSector = places[a][b];
        		for(int c = 0 ; c < placeSector.length() ; c++) {
        			String person = String.valueOf(placeSector.charAt(c));
        			place[b][c] = person;
        			if(person.equals("P")) pass = true;
        		}//end for()
        	}//end for()
        	
        	if(pass) {	//응시자가 있으면
        		//거리두기 탐색
        		for(int x = 0 ; x < place.length ; x++) {
            		for(int y = 0 ; y < place[x].length ; y++) {
            			//방문한 적이 없고, 응시자인 경우 탐색
            			if(!visited[x][y] && place[x][y].equals("P")) {
            				dfs(x, y, 0);
            			}//end if()
                	}//end for()
            	}//end for()
        		
        		if(keepDistance) {	//거리두기 o
        			answer[a] = 1;
        		} else {			//거리두기 x
        			answer[a] = 0;
        		}
        	} else {	//응시자가 없으면
        		answer[a] = 1;
        	}//end if()
        	
        }//end for()
        return answer;
    }//end solution()

	private static void dfs(int x, int y, int d) {
		//방문 여부 체크
		visited[x][y] = true;
		
		//맨해튼 거리가 2이하인 경우 탐색 
		if(d < 2) {
			
			//이동경로별 탐색
			for(int a = 0 ; a < pattern.length ; a++) {
				int moveX = x + pattern[a][0];
				int moveY = y + pattern[a][1];
				
				//대기실 범위를 넘어선 경우
				if(moveX < 0 || moveY < 0 || place.length - 1 < moveX || place[0].length - 1 < moveY) continue;
				
				//방문한 적이 있는 경우
				if(visited[moveX][moveY]) continue;
				
				//파티션이 있는 경우
				if(place[moveX][moveY].equals("X")) continue;
				
				//위 경우를 통과한 경우 이동 경로 탐색
				if(place[moveX][moveY].equals("P")) {	//탐색 중 응시자가 발견된 경우
					keepDistance = false;
				} else {								//탐색 중 응시자가 발견되지 않은 경우
					dfs(moveX, moveY, d + 1);
				}//end if()
			}//end for()
		}//end if()
			
	}//end dfs()

}//end class()
