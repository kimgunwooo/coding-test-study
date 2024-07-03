import java.io.*;
import java.util.*;

/**
 *
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N;
	public static boolean[] visited;
	public static Queue<Integer> queue = new LinkedList<>();
	public static List<List<Integer>> graph = new ArrayList<>();


	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N+1];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			graph.get(node).add(edge);
			graph.get(edge).add(node);
		}

		for(int i=0;i<N+1;i++) {
			Collections.sort(graph.get(i));
		}

		solution(V);
		System.out.println(sb);
	}

	private static void solution(int v) {
		dfs(v);
		sb.append("\n");
		bfs(v);
		sb.append("\n");
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");

		for(int node : graph.get(v)) {
			if(!visited[node])
				dfs(node);
		}
	}

	private static void bfs(int v) {
		visited = new boolean[N+1];

		queue.offer(v);
		visited[v] = true;

		while(!queue.isEmpty()) {
			int target = queue.poll();
			sb.append(target).append(" ");

			for(int node : graph.get(target)) {
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
			}
		}
	}
}