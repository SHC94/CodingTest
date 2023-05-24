package codingtest.baekjoon.BFS_DFS;

import java.util.Stack;

public class DFS {
	
	static final int MAX_N = 5;						//문제 조건
	static int N, E;								//N : 노드의 갯수 / E : 간선의 갯수
	static int[][] MAP = new int[MAX_N][MAX_N];		//전체 맵 생성
	static boolean[] VISITED = new boolean[MAX_N];	//방문 여부 확인
	
	public static void main(String[] args) {
		   
		//실행 타입
		//1 : 인접행렬
		//2 : 스택
		int excuteCase  = 2;  		
		String result	= "";
		
		N = 5;	//노드의 갯수
		E = 6;	//간선의 갯수
		
		int[][] eArr = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}};
		
		for(int i = 0 ; i < E ; ++i) {
			int x = eArr[i][0];
			int y = eArr[i][1]; 
			
			MAP[x][y] = MAP[y][x] = 1;	//인접 행렬 값 삽입
		}//end for()
		
		if(excuteCase == 1) dfs1(0); result = "인접행렬";  
		if(excuteCase == 2) dfs2(0); result = "스택";	
		
		System.out.println(result + " =======================================");
		for(int a = 0 ; a < MAP.length ; a++) {
			for(int b = 0 ; b < MAP[a].length ; b++) {
				System.out.print(MAP[a][b] + "\t");
			}//end for()
			System.out.println();
		}//end for()
		System.out.println("==============================================");
	}//end main()

	/**인접 행렬*/
	private static void dfs1(int node) {
		
		VISITED[node] = true;
		System.out.println(node + " ");
		
		for(int next = 0 ; next < N ; ++next) {
			if(!VISITED[next] && MAP[node][next] != 0) {	//방문한 적이 없고, 간선이 존재
				dfs1(next);	//재귀 호출
			}//end if()
		}//end for()
		
	}//end dfs1()
	
	/**스택*/
	private static void dfs2(int node) {
		boolean[] visited 		= new boolean[MAX_N];		//지역 변수로 빠진 이유 : stack overflow를 방지
		Stack<Integer> stack 	= new Stack<Integer>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			
			if(visited[curr]) continue;			//방문 여부 확인
			
			visited[curr] = true;				//방문 여부 마킹
			System.out.println(curr + " ");
			
			for(int next = 0 ; next < N ; ++next) {
				if(!visited[next] && MAP[curr][next] != 0) {	//방문하지 않고, 간선이 존재
					stack.push(next);
				}//end if()
			}//end for()
			
		}//end while()
		
		
//		기준		0		2(pop)	4(pop)	3(pop)	1(pop)	1(pop)	1(pop)
//			
//								3		1
//				2		4		1		1		1
//		stack 	1		1		1		1		1		1		
	}//end dfs2()
	
}//end class()
