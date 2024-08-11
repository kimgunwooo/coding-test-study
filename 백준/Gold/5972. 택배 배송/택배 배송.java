import java.io.*;
import java.util.*;

/**
 * 1 ≤ N, M ≤ 50_000
 * 0 ≤ C_i ≤ 1_000
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * N : 노드, M : 간선, C_i : 가중치
 * 최소 경로를 구하면 됨. 대신 가중치가 존재함. 무방향그래프
 * 다익스트라 사용.
 * 거리 배열을 통해 현재 노드부터 각 노드까지 최소 거리를 업데이트.
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static List<List<Node>> graph;

	public static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 노드의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수

		graph = new ArrayList<>();
		for (int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(n1).add(new Node(n2, weight));
			graph.get(n2).add(new Node(n1, weight));
		}

		int result = dijkstra(1, N);

		System.out.println(result);
	}

	private static int dijkstra(int start, int N) {
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		queue.add(new Node(start, dist[start]));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (dist[cur.node] < cur.weight) continue;

			for (Node next : graph.get(cur.node)) {
				if (dist[next.node] > dist[cur.node] + next.weight) {
					dist[next.node] = dist[cur.node] + next.weight;
					queue.add(new Node(next.node, dist[next.node]));
				}
			}
		}

		return dist[N];
	}
}