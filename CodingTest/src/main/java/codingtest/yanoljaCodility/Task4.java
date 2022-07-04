package codingtest.yanoljaCodility;

public class Task4 {

	//두개의 문자열 L1과 L2가 각각 동일한 길이의 N세그먼트로 구성된 첫 번째 차선과 두번째 차선을 나타내는 2차선 도로에 대한 설명이 제공
	
	//첫번째 레인의 K번째 세그먼트는 L1[K]로 표시되고 
	//두번째 레인의 K번째 세그먼트는 L2[K]로 표시됩니다.
	//여기서 . 은 도로의 부드러운 구간을 나타내고
	//X는 움푹 들어간 곳이 있는 구간을 나타냅니다.
	
	//자동차는 구덩이가 있는 구간을 지나갈 수 있지만 불편합니다.
	
	//따라서 최대한 많은 움푹 들어간 곳을 수리하는 프로젝트가 생겼다.
	//구간을 지날수 있는 경우, 최대 X의 갯수
	
	private static String[][] map;
	private static boolean[][] visited;
	private static int xCnt;
	private static boolean pass;
	private static int[][] pattern = {{0, 1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) {
		
//		String L1	= "..xx.x.";
//		String L2	= "x.x.x..";
		
		String L1	= ".xxx...x";
		String L2	= "..x.xxxx";
		
		int result 	= solution(L1, L2);
		
		System.out.println("result = " + result);
	}

	private static int solution(String L1, String L2) {
		int result 		= 0;	//결과
		
		//x를 0개 지우는 것부터 n개 지우는 것 까지 탐색 (지우는 경우의 수)
		for(int life = 0 ; life <= L1.length() ; life++) {
			//시작 지점의 경우
			int[][] startCase = {{0, 0}, {1, 0}};
			
			for(int start = 0 ; start < startCase.length ; start++) {
				
				//도로 상태 초기화
				init(L1, L2);
				
				visited[startCase[start][0]][startCase[start][1]] = true;
				dfs(startCase[start][0], startCase[start][1], life, map, visited);
				
				//도로를 통과한 경우
				if(pass) break;
				
			}//end for()
			
			//도로를 통과한 경우
			if(pass) {
				//남은 x의 갯수
				result = xCnt - life;
				break;
			}//end if()
			
		}//end for()
		
		return result;
	}//end solution()

	private static void init(String L1, String L2) {
		map 	= new String[2][L1.length()];	//도로
		visited = new boolean[2][L1.length()];	//도로방문여부
		pass 	= false;						//도로 통과 여부
		xCnt	= 0;							//움푹 파인 곳의 갯수
		
		//도로 상태 채우기
		String[] streetArr = {L1, L2};
		for(int a = 0 ; a < map.length ; a++) {
			String street = streetArr[a];
			for(int b = 0 ; b < street.length() ; b++) {
				String streetCondition = String.valueOf(street.charAt(b));
				map[a][b] = streetCondition;
				if("x".equals(streetCondition)) xCnt++;
			}//end for()
		}//end for()
	}//end init()

	private static void dfs(int i, int j, int life, String[][] tempMap, boolean[][] tempVisited) {
		
		//방문 여부 체크
		tempVisited[i][j] = true;
		
		//도로 끝 지점까지 도달한 경우 
		if(j == (tempMap[0].length - 1)) {
			pass = true;
			return;
		}//end if()
		
		//가능한 이동 경로별 탐색 
		for(int a = 0 ; a < pattern.length ; a++) {
			int moveX = pattern[a][0] + i;
    		int moveY = pattern[a][1] + j;

			boolean repair = false;
			//도로 범위를 벗어난 경우
			if(moveX < 0 || moveY < 0 || tempMap.length - 1 < moveX || tempMap[0].length -1 < moveY) continue;
			
			//방문 했던 곳인 경우
			if(tempVisited[moveX][moveY]) continue;
			
			//움푹 파인 곳을 만났으며, 수리할 수 있는 경우
			if(("x".equals(tempMap[moveX][moveY])) && (0 < life)) {
				repair = true;
				tempMap[moveX][moveY] = "R";	//수리
			}//end if()
			
			//다시 지나갑니다
			if("x".equals(tempMap[moveX][moveY])) continue;

			if(repair) dfs(moveX, moveY, life - 1, tempMap, tempVisited);
			else dfs(moveX, moveY, life, tempMap, tempVisited);
			
		}//end for()
	}//end dfs()
	
}//end class()
