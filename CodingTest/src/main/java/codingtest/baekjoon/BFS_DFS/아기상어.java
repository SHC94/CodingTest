package codingtest.baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어 {
	
	private static int n;
	private static int[][] map;
	private static int[][] pattern = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
	private static ArrayList<Node> fishes;

	public static void main(String[] args) {
		Scanner sc 		= new Scanner(System.in);
		n 				= sc.nextInt();
		map 			= new int[n][n];
		Queue<Node> q 	= new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					q.add(new Node(i, j, 0));
					map[i][j] = 0;
				}//end if()
			}//end for()
		}//end for()

		int eat 	= 0;
		int time 	= 0;
		int age 	= 2;
		
		while (true) {
			LinkedList<Node> fish = new LinkedList<>();
			int[][] dis = new int[n][n];

			while (!q.isEmpty()) {
				Node current = q.poll();

				for (int i = 0; i < 4; i++) {
					int moveX = current.x + pattern[i][0];
					int moveY = current.y + pattern[i][1];

					if (moveX >= 0 && moveY >= 0 && moveX < n && moveY < n && dis[moveX][moveY] == 0 && map[moveX][moveY] <= age) {
						dis[moveX][moveY] = dis[current.x][current.y] + 1;
						
						q.add(new Node(moveX, moveY, dis[moveX][moveY]));
						
						if (1 <= map[moveX][moveY] && map[moveX][moveY] <= 6 && map[moveX][moveY] < age) {
							fish.add(new Node(moveX, moveY, dis[moveX][moveY]));
						}//end if()
					}//end if()
				}//end for()
			}//end while()

			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}//end if()

			Node currentFish = fish.get(0);
			
			for (int i = 1; i < fish.size(); i++) {
				if (currentFish.dis > fish.get(i).dis) {
					currentFish = fish.get(i);
				} else if (currentFish.dis == fish.get(i).dis) {
					if ((currentFish.x > fish.get(i).x)
							|| (currentFish.x == fish.get(i).x && currentFish.y > fish.get(i).y)) {
						currentFish = fish.get(i);
					}//end if()
				}//end if()
			}//end for()

			time += currentFish.dis;
			eat++;
			map[currentFish.x][currentFish.y] = 0;
			
			if (eat == age) {
				age++;
				eat = 0;
			}//end if()
			
			q.add(new Node(currentFish.x, currentFish.y, 0));
		}//end while()
	}//end main()	
}//end class()

class Node {
    int x;
    int y;
    int dis;
    
    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}//end class()