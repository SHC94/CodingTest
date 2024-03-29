package codingtest.baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {
	private static final int INF = 1000000000;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, M, X;
	private static List<List<Node>> list, reverseList;
	private static int[] dist, reverseDist;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		reverseList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}

		dist = new int[N + 1];
		reverseDist = new int[N + 1];
		Arrays.fill(dist, INF);
		Arrays.fill(reverseDist, INF);

		for (int i = 1; i <= M; i++) {
			st 			= new StringTokenizer(br.readLine());
			int start 	= Integer.parseInt(st.nextToken());
			int end 	= Integer.parseInt(st.nextToken());
			int time 	= Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(end, time));
			reverseList.get(end).add(new Node(start, time));
		}//end for()

		dijkstra(list, dist, X);
		dijkstra(reverseList, reverseDist, X);

		print();
		br.close();
	}//end main()

	private static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));

		distance[start] = 0;

		while (!queue.isEmpty()) {
			int idx = queue.poll().index;

			if (visited[idx])
				continue;
			visited[idx] = true;

			for (Node node : list.get(idx)) {
				if (distance[node.index] > distance[idx] + node.distance) {
					distance[node.index] = distance[idx] + node.distance;
					queue.add(new Node(node.index, distance[node.index]));
				}//end if()
			}//end for()
			
		}//end while()
		
	}//end dijkstra()

	private static void print() {
		int ans = -1;
		
		for (int i = 1; i <= N; i++) ans = Math.max(ans, dist[i] + reverseDist[i]);
		
		System.out.println(ans);
	}//end print()
	
	
	static class Node implements Comparable<Node> {
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}//end class()
}//end class()
